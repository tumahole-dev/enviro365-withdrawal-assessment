package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Marks this as the entry point of the Spring Boot app.
// Bundles together @Configuration, @EnableAutoConfiguration, and @ComponentScan,
// so Spring auto-configures beans and scans this package (and sub-packges) for controllers, 
// services, and repositories.
@SpringBootApplication
public class TumaholenkhathoApplication {

	public static void main(String[] args) {
		// Boots up the embedded Tomcat server and starts the whole Spring application context.
		SpringApplication.run(TumaholenkhathoApplication.class, args);
	}

}
