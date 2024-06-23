package org.example.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.admin.dao.entity.UserDO;
import org.example.admin.dto.req.UserRegisterReqDTO;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/6/23 11:49
 */
public interface UserService extends IService<UserDO> {
    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户名存在返回 True，不存在返回 False
     */
    Boolean hasUsername(String username);

    /**
     * 用户注册
     * @param requestParam
     * @return
     */
    void register(UserRegisterReqDTO requestParam);
}
