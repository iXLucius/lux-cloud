package com.tencloud.lux.security.common.exception.auth;


import com.tencloud.lux.security.common.constant.CommonConstants;
import com.tencloud.lux.security.common.exception.BaseException;

public class TokenErrorException extends BaseException {
    public TokenErrorException(String message, int status) {
        super(message, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}
