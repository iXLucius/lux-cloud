package com.tencloud.lux.security.auth.client.configuration;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tencloud.lux.security.auth.client.config.ServiceAuthConfig;
import com.tencloud.lux.security.auth.client.config.UserAuthConfig;

@Configuration
@ComponentScan({"com.tencloud.lux.security.auth.client","com.tencloud.lux.security.auth.common.event"})
@RemoteApplicationEventScan(basePackages = "com.tencloud.lux.security.auth.common.event")
public class AutoConfiguration {
    @Bean
    ServiceAuthConfig getServiceAuthConfig(){
        return new ServiceAuthConfig();
    }

    @Bean
    UserAuthConfig getUserAuthConfig(){
        return new UserAuthConfig();
    }
}
