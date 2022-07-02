package com.onix.rev.zirliockcoffeconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ZirliockcoffeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZirliockcoffeConfigServerApplication.class, args);
	}

}
