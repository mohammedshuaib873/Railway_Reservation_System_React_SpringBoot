package com.RailwayUserManagenet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mohammed Shuaib A T
 * Main Method For User Management MicroService
 */
@SpringBootApplication
@EnableEurekaClient
public class RailwayReservationUsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationUsermanagementApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	} 
}
