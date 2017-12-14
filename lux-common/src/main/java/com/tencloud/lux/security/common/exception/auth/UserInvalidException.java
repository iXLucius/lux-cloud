package com.tencloud.lux.security.common.exception.auth;


import com.tencloud.lux.security.common.constant.CommonConstants;
import com.tencloud.lux.security.common.exception.BaseException;

public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
