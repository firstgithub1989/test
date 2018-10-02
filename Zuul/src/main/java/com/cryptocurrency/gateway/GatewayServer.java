package com.cryptocurrency.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

//@EnableOAuth2Sso

//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableZuulProxy
@SpringBootApplication
@RestController
public class GatewayServer {


    @Bean
    AuthFilter authFilter() {
        return new AuthFilter();
    }

    //@Autowired
    //private Principal principal;

    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }

    @GetMapping(value="/login")
    public User login(Principal principal, HttpServletRequest httpServletRequest) {
        User user = new User();
        user.userName = "user";
        //httpServletRequest.getUserPrincipal().getName();
        return user;
    }
}

class User {
    public String userName;
}

