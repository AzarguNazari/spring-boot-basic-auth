package com.springboot.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class BasicAuthenticationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthenticationApplication.class, args);
	}

	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}
}
