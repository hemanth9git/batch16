package com.tejait.batch16.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tejait.batch16.dto.PostsDto;

@FeignClient(
		name="typicode",//name can be anything 
		url = "https://jsonplaceholder.typicode.com"//URL must be the 3rd party URL
		//Or the site url that we want to fetch
		)
public interface FeignClientData {

@GetMapping("posts")
public List<PostsDto> getPosts();

//@GetMapping("comments")
//public List<CommentsDto> getComments();
/*
 * Like above we can create multiple sub urls to access the data
 */
}
