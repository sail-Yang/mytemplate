package org.example.admin.common.convention.exception;

import org.example.admin.common.convention.errorcode.BaseErrorCode;
import org.example.admin.common.convention.errorcode.IErrorCode;

/**
 * @author yangfan
 * @version 1.0
 * @description: 远程服务调用异常
 * @date 2024/6/23 11:24
 */
public class RemoteException extends AbstractException{
    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
