package com.palle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMicroserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceProjectApplication.class, args);
	}

}
