package com.tencloud.lux.security.common.exception.auth;


import com.tencloud.lux.security.common.constant.CommonConstants;
import com.tencloud.lux.security.common.exception.BaseException;

public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
