package com.tencloud.lux.security.common.msg.auth;

import com.tencloud.lux.security.common.constant.RestCodeConstants;
import com.tencloud.lux.security.common.msg.BaseResponse;

public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
