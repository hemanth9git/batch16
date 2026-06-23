package com.tejait.batch16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ctrl")
public class ControllerTest {

	@ResponseBody
	@GetMapping("test")
	public String test() {
		return "test";
	}
	/*
	 * the thing we have to learn here is to the @Contoller annotation will return view 
	 * so we have to implement the @ResponseBody annotation to return the rest object
	 * If you want to directly return the rest type then use @RestContoller annotation
	 * And one more important thing is the all the beans are imported from the stereotype package
	 * and the the @RestContoller is from web.bind.annotation.RestController
	 * 
	 */
}
