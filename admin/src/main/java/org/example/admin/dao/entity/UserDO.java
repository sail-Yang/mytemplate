package org.example.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.example.admin.common.database.BaseDO;

import java.io.Serializable;

/**
 * @author yangfan
 * @version 1.0
 * @description: t_user
 * @date 2024/6/23 11:43
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type =  IdType.AUTO)
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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

    /**
     * 注销时间戳
     */
    private Long deletionTime;

}
