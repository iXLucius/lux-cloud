package com.tencloud.lux.security.admin;

import com.tencloud.lux.cache.EnableAceCache;
import com.tencloud.lux.security.auth.client.EnableAceAuthClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"com.tencloud.lux.security.auth.client.feign"})
@EnableScheduling
@EnableAceAuthClient
@ServletComponentScan("com.tencloud.lux.security.admin.config.druid")
@EnableAceCache
@EnableTransactionManagement
public class AdminBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminBootstrap.class).web(true).run(args);    }
}
