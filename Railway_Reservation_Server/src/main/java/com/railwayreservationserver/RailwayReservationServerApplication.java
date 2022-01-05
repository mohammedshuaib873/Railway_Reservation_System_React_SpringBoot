package com.railwayreservationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RailwayReservationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationServerApplication.class, args);
	}

}
