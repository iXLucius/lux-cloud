package com.tencloud.lux.security.gate.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tencloud.lux.security.auth.client.config.ServiceAuthConfig;
import com.tencloud.lux.security.auth.client.config.UserAuthConfig;
import com.tencloud.lux.security.auth.client.interceptor.ServiceFeignInterceptor;
import com.tencloud.lux.security.auth.client.jwt.ServiceAuthUtil;

import feign.RequestInterceptor;

/**
 * @(#)FeignClientConfig.java 1.0 2017年12月11日
 * @Copyright:  Copyright 2015 - 2017 HUA HAI LE YING NETWORK TECHNOLOGY GROUP. All Rights Reserved.
 * @Description: 
 * 
 * Modification History:
 * Date:        2017年12月11日
 * Author:      lucius.lv
 * Version:     1.0.0.0
 * Description: (Initialize)
 * Reviewer:    
 * Review Date: 
 */
/*@Configuration
public class FeignClientConfig {
    
    @Autowired
    private ServiceFeignInterceptor serviceFeignInterceptor;
    
    @Bean
    public RequestInterceptor headerInterceptor() {
        return serviceFeignInterceptor;
    }

}*/

