package com.tencloud.lux.security.gate;


import com.tencloud.lux.gate.ratelimit.EnableAceGateRateLimit;
import com.tencloud.lux.gate.ratelimit.config.IUserPrincipal;
import com.tencloud.lux.security.auth.client.EnableAceAuthClient;
import com.tencloud.lux.security.gate.config.UserPrincipal;
import com.tencloud.lux.security.gate.utils.DBLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.tencloud.lux.security.auth.client.feign","com.tencloud.lux.security.gate.feign"})
@EnableZuulProxy
@EnableScheduling
@EnableAceAuthClient
@EnableAceGateRateLimit
@RestController
public class GateBootstrap {
    
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    @Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }
}
