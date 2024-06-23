package org.example.admin.common.constant;

/**
 * @author yangfan
 * @version 1.0
 * @description: redis cache
 * @date 2024/6/23 12:28
 */
public class RedisCacheConstant {
    /**
     * 用户注册分布式锁
     */
    public static final String LOCK_USER_REGISTER_KEY = "mytemplate:lock_user-register:";

    /**
     * 用户登录缓存标识
     */
    public static final String USER_LOGIN_KEY = "mytemplate:login:";
}
