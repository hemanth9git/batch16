package com.tejait.batch16.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("restTest")
public class RestTemplateController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("name")
	public String getName() {
		String tagline=restTemplate.getForObject("http://localhost:8082/rest/tagline", String.class);
		return "Hemanth Sai ".concat(tagline);
	}
}
