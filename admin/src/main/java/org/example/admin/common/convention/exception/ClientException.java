package org.example.admin.common.convention.exception;

import org.example.admin.common.convention.errorcode.BaseErrorCode;
import org.example.admin.common.convention.errorcode.IErrorCode;

/**
 * @author yangfan
 * @version 1.0
 * @description: 客户端异常
 * @date 2024/6/23 11:23
 */
public class ClientException extends AbstractException {
    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
