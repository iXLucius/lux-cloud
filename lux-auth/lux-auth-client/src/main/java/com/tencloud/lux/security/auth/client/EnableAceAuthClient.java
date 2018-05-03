package com.tencloud.lux.security.auth.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tencloud.lux.security.auth.client.configuration.AutoConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAceAuthClient {
}
