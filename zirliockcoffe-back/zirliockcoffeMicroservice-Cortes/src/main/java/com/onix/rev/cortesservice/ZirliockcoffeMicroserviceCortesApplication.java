package com.onix.rev.cortesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZirliockcoffeMicroserviceCortesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZirliockcoffeMicroserviceCortesApplication.class, args);
    }

}
