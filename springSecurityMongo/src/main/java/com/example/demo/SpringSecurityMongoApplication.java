package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMongoApplication.class, args);
	}

}
//Important points

// not able to sign up using same username
// password validation
//make sure jwt expires after 30 mins
//role based authorization using jwt
//email validation