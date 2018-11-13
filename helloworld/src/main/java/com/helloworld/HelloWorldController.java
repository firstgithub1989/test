package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldController {


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class);
    }

    @GetMapping("/helloWold")
    public String helloWorld() {
        return "Hello World";
    }

}
