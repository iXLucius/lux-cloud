package com.tencloud.lux.security.auth.configuration;

import com.tencloud.lux.security.common.handler.GlobalExceptionHandler;
import com.tencloud.lux.security.auth.common.util.jwt.RsaKeyHelper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Configuration
public class AuthConfiguration {


    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

}
