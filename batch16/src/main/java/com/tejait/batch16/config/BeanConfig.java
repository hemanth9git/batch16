package com.tejait.batch16.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

	@Bean
	public RestTemplate getRestTemplate() { //this is the way to create our own beans
		
		return new RestTemplate();
	}
	/*
	 * We can create the beans manually with the @Configuration annotation
	 * And for the class we want to create the bean then use @Bean annotation
	 * Above is the method to create the beans manually
	 */
}
