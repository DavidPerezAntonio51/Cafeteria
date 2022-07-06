package com.onix.rev.personalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZirliockcoffeMicroservicePersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZirliockcoffeMicroservicePersonalApplication.class, args);
    }

}
