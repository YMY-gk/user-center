package com.user.config.bean;


import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Configuration
@Component
@ConfigurationProperties(prefix = "initialization")
@Data
public  class InitializationBean {
    public  String userName;
    public  String password;
    public  String customPwd;
}
