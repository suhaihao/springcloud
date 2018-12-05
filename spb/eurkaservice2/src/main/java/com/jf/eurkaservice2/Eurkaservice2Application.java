package com.jf.eurkaservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eurkaservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurkaservice2Application.class, args);
	}
}
