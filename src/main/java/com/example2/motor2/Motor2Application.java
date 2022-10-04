package com.example2.motor2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Motor2Application {


	private static final Logger log = LoggerFactory.getLogger(Motor2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Motor2Application.class, args);
	}

}
