package com.firstSpringProject.Blog.services;

import java.util.List;

import com.firstSpringProject.Blog.entities.User;
import com.firstSpringProject.Blog.payloads.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
}
