package com.tejait.batch16.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch16.dto.PostsDto;

@RestController
@RequestMapping("feign")
public class FeignController {
	
	@Autowired
	FeignClientData feign;
	
	@GetMapping("getPosts")
	public ResponseEntity<List<PostsDto>> getPosts(){
		List<PostsDto> posts=feign.getPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	

}
