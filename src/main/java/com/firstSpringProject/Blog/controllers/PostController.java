package com.firstSpringProject.Blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringProject.Blog.payloads.PostDTO;
import com.firstSpringProject.Blog.payloads.RequestResponseDTO;
import com.firstSpringProject.Blog.services.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/createPost")
	public RequestResponseDTO createPost(@RequestBody PostDTO postDTO) {
		postService.createPost(postDTO);
		return postDTO;
	}
	
	@PostMapping("/updatePost")
	public void updatePost(@RequestBody PostDTO postDTO,@RequestParam int postId) {
		postService.updatePost(postDTO,postId);
	}
	
	@PostMapping("/deletePost")
	public RequestResponseDTO deletePost(@RequestBody PostDTO postDTO) {
		postService.deletePost(postDTO);
		return postDTO;
	}
	
	@PostMapping("/getAllPost")
	public List<PostDTO> getAllPost(@RequestBody PostDTO postDTO) {
		return postService.getAllPost(postDTO);
	}
	
	@PostMapping("/getAllPostByCategory")
	public List<PostDTO> getAllPostByCategory(@RequestBody PostDTO postDTO) {
		return postService.getAllPostByCategory(postDTO);
	}
	
	@PostMapping("/getAllPostByUser")
	public List<PostDTO> getAllPostByUser(@RequestBody PostDTO postDTO) {
		return postService.getAllPostByUser(postDTO);
		
	}
}
