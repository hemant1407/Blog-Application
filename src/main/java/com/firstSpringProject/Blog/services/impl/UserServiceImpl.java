package com.firstSpringProject.Blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpringProject.Blog.entities.User;
import com.firstSpringProject.Blog.exceptions.ResourceNotFoundException;
import com.firstSpringProject.Blog.payloads.UserDTO;
import com.firstSpringProject.Blog.repositories.UserRepo;
import com.firstSpringProject.Blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user= UserDTOtoUser(userDTO);
		User savedUser=userRepo.save(user);
		return userToUserDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		User userToAdd= new User();
		if(userDTO.getPassword()==null)
			userDTO.setPassword(user.getPassword());
		userToAdd=UserDTOtoUser(userDTO);
		userRepo.save(userToAdd);
		UserDTO userDTO1= userToUserDTO(userToAdd);
		return userDTO1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));		
		return userToUserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users=userRepo.findAll();
// Use of stream and map
		List<UserDTO> userDTOs=users.stream().map(user-> userToUserDTO(user)).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);
	}
	
	private User UserDTOtoUser(UserDTO userDTO) {
		User user=modelMapper.map(userDTO, User.class);
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setAbout(userDTO.getAbout());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	public UserDTO userToUserDTO(User user) {
		UserDTO userDTO=modelMapper.map(user, UserDTO.class);
//		userDTO.setId(user.getId());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setAbout(user.getAbout());
//		userDTO.setName(user.getName());
		return userDTO;
	}

}
