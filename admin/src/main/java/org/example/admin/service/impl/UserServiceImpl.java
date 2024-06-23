package org.example.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.admin.common.convention.exception.ClientException;
import org.example.admin.common.enums.UserErrorCodeEnum;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dao.mapper.UserMapper;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import static org.example.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/6/23 11:49
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;


    @Override
    public Boolean hasUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if(hasUsername(requestParam.getUsername())) {
            throw  new ClientException(UserErrorCodeEnum.USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            if(lock.tryLock()) {
                try {
                    int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                    if(inserted < 1) {
                        throw new ClientException(UserErrorCodeEnum.USER_SAVE_ERROR);
                    }
                } catch (DuplicateKeyException ex) {
                    throw new ClientException(UserErrorCodeEnum.USER_EXIST);
                }
            }
            userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
        }catch (Throwable e) {
            throw new ClientException(UserErrorCodeEnum.USER_SAVE_ERROR);
        }finally {
            lock.unlock();
        }
    }
}
