package com.firstSpringProject.Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringProject.Blog.payloads.UserDTO;
import com.firstSpringProject.Blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		UserDTO createUserDTO= userService.createUser(userDTO);
		return new ResponseEntity<>(createUserDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
		UserDTO updateUser= userService.updateUser(userDTO,userDTO.getId());
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> deleteUser(@RequestBody UserDTO userDTO){
		userService.deleteUser(userDTO.getId());
		return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
	}
	
	@PostMapping("/getUserById")
	public ResponseEntity<UserDTO> getUserById(@RequestBody UserDTO userDTO){
		UserDTO userDetails = userService.getUserById(userDTO.getId());
		return new ResponseEntity<UserDTO>(userDetails,HttpStatus.OK);
	}
}
