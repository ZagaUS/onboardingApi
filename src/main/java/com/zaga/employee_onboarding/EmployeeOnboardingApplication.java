package com.zaga.employee_onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.zaga.employee_onboarding"})
public class EmployeeOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeOnboardingApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/**")
    //         .allowedOrigins("*")
    //         .allowedMethods("GET", "POST", "PUT", "DELETE")
    //         .allowedHeaders("*")
    //         .allowCredentials(false);
	// 		}
	// 	};
	}


