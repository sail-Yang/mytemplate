package org.example.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.example.admin.common.serialize.PhoneDesensitizationSerializer;

/**
 * @author yangfan
 * @version 1.0
 * @description: TODO
 * @date 2024/6/23 12:59
 */
@Data
public class UserActualRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
