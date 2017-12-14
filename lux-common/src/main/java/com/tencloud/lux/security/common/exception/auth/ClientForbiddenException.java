package com.tencloud.lux.security.common.exception.auth;


import com.tencloud.lux.security.common.constant.CommonConstants;
import com.tencloud.lux.security.common.exception.BaseException;

public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
