package com.tencloud.lux.security.auth;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@SpringBootApplication(exclude= {PageHelperAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.tencloud.lux.security.auth.mapper")
@RemoteApplicationEventScan(basePackages = "com.tencloud.lux.security.auth.common.event")
public class AuthBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AuthBootstrap.class, args);
    }
}
