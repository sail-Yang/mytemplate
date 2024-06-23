package org.example.admin.common.convention.errorcode;

/**
 * @author yangfan
 * @version 1.0
 * @description: 平台错误码
 * @date 2024/6/23 11:18
 */
public interface IErrorCode {
    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}
