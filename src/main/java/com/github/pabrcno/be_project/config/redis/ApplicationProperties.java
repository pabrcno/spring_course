package com.github.pabrcno.be_project.config.redis;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ApplicationProperties {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.timeOfLife}")
    private Integer timeOfLife;
}