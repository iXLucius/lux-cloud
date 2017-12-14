package com.tencloud.lux.security.gate.config;

import com.tencloud.lux.gate.ratelimit.config.IUserPrincipal;
import com.tencloud.lux.security.auth.client.config.UserAuthConfig;
import com.tencloud.lux.security.auth.client.jwt.UserAuthUtil;
import com.tencloud.lux.security.auth.common.util.jwt.IJWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;


public class UserPrincipal implements IUserPrincipal {

    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private UserAuthUtil userAuthUtil;

    @Override
    public String getName(HttpServletRequest request) {
        IJWTInfo infoFromToken = getJwtInfo(request);
        return infoFromToken == null ? null : infoFromToken.getUniqueName();
    }

    private IJWTInfo getJwtInfo(HttpServletRequest request) {
        IJWTInfo infoFromToken = null;
        try {
            String authToken = request.getHeader(userAuthConfig.getTokenHeader());
            if(StringUtils.isEmpty(authToken)) {
                infoFromToken = null;
            } else {
                infoFromToken = userAuthUtil.getInfoFromToken(authToken);
            }
        } catch (Exception e) {
            infoFromToken = null;
        }
        return infoFromToken;
    }

}
