
package com.tencloud.lux.security.auth.client.jwt;

import com.tencloud.lux.security.auth.common.event.AuthRemoteEvent;
import com.tencloud.lux.security.auth.common.util.jwt.IJWTInfo;
import com.tencloud.lux.security.auth.common.util.jwt.JWTHelper;
import com.tencloud.lux.security.common.msg.BaseResponse;
import com.tencloud.lux.security.common.msg.ObjectRestResponse;
import com.tencloud.lux.security.auth.client.config.ServiceAuthConfig;
import com.tencloud.lux.security.auth.client.exception.JwtIllegalArgumentException;
import com.tencloud.lux.security.auth.client.exception.JwtSignatureException;
import com.tencloud.lux.security.auth.client.exception.JwtTokenExpiredException;
import com.tencloud.lux.security.auth.client.feign.ServiceAuthFeign;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
//@Slf4j
//@EnableScheduling
//@Component
public class ServiceAuthUtil implements ApplicationListener<AuthRemoteEvent> {
    
    private static final Logger log = LoggerFactory.getLogger(ServiceAuthUtil.class);
    
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    private List<String> allowedClient;
    private String clientToken;
    
    
    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyPath());
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenExpiredException("Client token expired!");
        } catch (SignatureException ex) {
            throw new JwtSignatureException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new JwtIllegalArgumentException("Client token is null or empty!");
        }
    }

    public void refreshAllowedClient() {
        log.info("refresh allowedClient.....");
        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void refreshClientToken() {
        log.info("refresh client token.....");
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            log.info("获取的client token = {}",clientToken.getData());
            this.clientToken = clientToken.getData();
        }
    }


    public String getClientToken() {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }

    @Override
    public void onApplicationEvent(AuthRemoteEvent authRemoteEvent) {
        this.allowedClient = authRemoteEvent.getAllowedClient();
    }
}