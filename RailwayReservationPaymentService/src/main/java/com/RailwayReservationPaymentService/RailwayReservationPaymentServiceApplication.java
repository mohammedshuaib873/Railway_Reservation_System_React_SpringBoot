package com.RailwayReservationPaymentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
/**
 * @author Mohammed Shuaib A T
 * Main Method For Payment Microservice
 */
@SpringBootApplication
@EnableEmailTools
public class RailwayReservationPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationPaymentServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	} 
}
