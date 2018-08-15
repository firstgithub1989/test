package com.cryptocurrency.dataanalytics.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@EnableSidecar
public class DataAnalyticsSidecar {
    public static void main(String[] args) {
        SpringApplication.run(DataAnalyticsSidecar.class, args);
    }
}
