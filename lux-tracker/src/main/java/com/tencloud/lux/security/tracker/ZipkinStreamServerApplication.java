package com.tencloud.lux.security.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinStreamServerApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamServerApplication.class,args);
    }
    
}
