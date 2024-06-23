package org.example.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dao.mapper.UserMapper;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.springframework.stereotype.Service;

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


    @Override
    public Boolean hasUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {

    }
}
