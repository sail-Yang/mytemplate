package org.example.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.admin.common.convention.result.Result;
import org.example.admin.common.convention.result.Results;
import org.example.admin.dto.req.UserRegisterReqDTO;
import org.example.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/6/23 11:57
 */
@RestController
@RequiredArgsConstructor
public class UserContoller {
    private final UserService userService;

    /**
     * 查询用户名是否存在
     */
    @GetMapping("/api/admin/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 用户注册
     */
    @PostMapping("/api/admin/v1/user/register")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }
}
