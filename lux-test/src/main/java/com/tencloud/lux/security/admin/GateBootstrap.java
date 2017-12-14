package com.tencloud.lux.security.admin;


import com.tencloud.lux.gate.ratelimit.EnableAceGateRateLimit;
import com.tencloud.lux.security.auth.client.EnableAceAuthClient;
import com.tencloud.lux.security.auth.client.feign.ServiceAuthFeign;
import com.tencloud.lux.security.common.msg.ObjectRestResponse;
import com.tencloud.lux.security.gate.utils.DBLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.tencloud.lux.security.auth.client.feign"/*,"com.tencloud.lux.security.gate.feign"*/})
@EnableZuulProxy
@EnableScheduling
@EnableAceAuthClient
@EnableAceGateRateLimit
@RestController
public class GateBootstrap {
    
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    
    @RequestMapping(value="/xxxx/yyyy",method=RequestMethod.GET)
    public Object x() {
        ObjectRestResponse accessToken = serviceAuthFeign.getAccessToken("lux-auth", "123456");
        return accessToken.getData();
    }
    
    public static void main(String[] args) {
        DBLog.getInstance().start();
        SpringApplication.run(GateBootstrap.class, args);
    }

    /*@Bean
    @Primary
    IUserPrincipal userPrincipal(){
        return new UserPrincipal();
    }*/
}
