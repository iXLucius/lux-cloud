package com.tencloud.lux.security.auth.client.interceptor;

import com.tencloud.lux.security.common.context.BaseContextHandler;
import com.tencloud.lux.security.common.msg.ObjectRestResponse;
import com.tencloud.lux.security.auth.client.config.ServiceAuthConfig;
import com.tencloud.lux.security.auth.client.config.UserAuthConfig;
import com.tencloud.lux.security.auth.client.jwt.ServiceAuthUtil;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Configuration
public class ServiceFeignInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(ServiceFeignInterceptor.class);
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private ServiceAuthUtil serviceAuthUtil;

    public ServiceFeignInterceptor() {
    }


    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(StringUtils.equalsIgnoreCase(requestTemplate.url(), "/client/myClient") || StringUtils.equalsIgnoreCase(requestTemplate.url(), "/client/token")) {
            logger.info("无需设置client token 和 user token");
            return;
        }
        
        logger.info("Fegin添加header Thread id = {},{}：{}：{}",requestTemplate.url(),Thread.currentThread().getName(),serviceAuthConfig.getTokenHeader(),serviceAuthUtil.getClientToken());
        logger.info("Fegin添加header Thread id = {},{}：{}：{}",requestTemplate.url(),Thread.currentThread().getName(),userAuthConfig.getTokenHeader(),BaseContextHandler.getToken());
        requestTemplate.header(serviceAuthConfig.getTokenHeader(), serviceAuthUtil.getClientToken());
        requestTemplate.header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken());
    }

    public void setServiceAuthConfig(ServiceAuthConfig serviceAuthConfig) {
        this.serviceAuthConfig = serviceAuthConfig;
    }

    public void setUserAuthConfig(UserAuthConfig userAuthConfig) {
        this.userAuthConfig = userAuthConfig;
    }

    public void setServiceAuthUtil(ServiceAuthUtil serviceAuthUtil) {
        this.serviceAuthUtil = serviceAuthUtil;
    }
}