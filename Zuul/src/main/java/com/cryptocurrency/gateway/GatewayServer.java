package com.cryptocurrency.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

//@EnableOAuth2Sso

//@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableZuulProxy
@SpringBootApplication
@RestController
@EnableEurekaClient
public class GatewayServer {


    @Bean
    AuthFilter authFilter() {
        return new AuthFilter();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    public static void main(String[] args) {
//        System.setProperty("eureka.client.serviceUrl.defaultZone","https://eureka.apps.internal:8080/eureka");
        SpringApplication.run(GatewayServer.class, args);

    }

    @CrossOrigin
    @GetMapping(value="/login")
    public ResponseEntity<String> login(Principal principal, HttpServletRequest httpServletRequest) {

        long userId = userDetailsService.findUserID(principal.getName());
        return new ResponseEntity<String>(Long.toString(userId), HttpStatus.OK);
    }

    @PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody UserDetails userDetails) {
        userDetailsService.saveUser(userDetails);
        return new ResponseEntity<String>("Registration Successful", HttpStatus.OK);
    }

    @GetMapping(value="/profile/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDetails> userDetails(@PathVariable("userId") long userId) {

        UserDetails userDetails = userDetailsService.findUser(userId);
        return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
    }

    //@Override
    public String getErrorPath() {
        return "/index.html";
    }
}

