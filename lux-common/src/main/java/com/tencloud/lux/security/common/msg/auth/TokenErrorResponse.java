package com.tencloud.lux.security.common.msg.auth;

import com.tencloud.lux.security.common.constant.RestCodeConstants;
import com.tencloud.lux.security.common.msg.BaseResponse;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
