package com.tencloud.lux.security.auth.interceptor;

import com.tencloud.lux.security.auth.configuration.ClientConfig;
import com.tencloud.lux.security.auth.service.AuthService;
import com.tencloud.lux.security.auth.service.ClientService;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public class ClientTokenInterceptor implements RequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(ClientTokenInterceptor.class);
    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private ClientService clientService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header(clientConfig.getClientTokenHeader(), clientService.apply(clientConfig.getClientId(), clientConfig.getClientSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
