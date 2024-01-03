package com.firstSpringProject.Blog.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.DestinationSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpringProject.Blog.entities.Categories;
import com.firstSpringProject.Blog.entities.PostTbl;
import com.firstSpringProject.Blog.entities.User;
import com.firstSpringProject.Blog.payloads.PostDTO;
import com.firstSpringProject.Blog.payloads.RequestResponseDTO;
import com.firstSpringProject.Blog.repositories.CategoriesRepo;
import com.firstSpringProject.Blog.repositories.PostRepo;
import com.firstSpringProject.Blog.repositories.UserRepo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class PostService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoriesRepo categoriesRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public void createPost(PostDTO postDTO) {
		
		User user= userRepo.findById(postDTO.getUserId()).orElse(null);
		if(user==null) {
			postDTO.setMessage("User Does Not Exist");
			return;
		}
		
		Categories categories  = categoriesRepo.findById(postDTO.getCategoryId()).orElse(null);
		if(categories==null) {
			postDTO.setMessage("Unknown Category");
			return;
		}
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		TypeMap<PostDTO, PostTbl> typeMap = modelMapper.createTypeMap(postDTO, PostTbl.class);
		typeMap.addMappings(modelMapper-> modelMapper.skip(PostTbl::setPostId));
		typeMap.addMappings(modelMapper-> modelMapper.skip(PostTbl::setAddedDate));
		
		PostTbl postTbl = modelMapper.map(postDTO, PostTbl.class);
		postTbl.setAddedDate(new Date());
		postTbl.setUser(user);
		postTbl.setCategory(categories);
		
		postRepo.save(postTbl);
		postDTO.setMessage("Post Created Successfully ...... ");
	}


	public void updatePost(PostDTO postDTO,int postId) {
		
		PostTbl postTbl = postRepo.findById(postId).orElse(null);
		if(postTbl!=null) {
			if(postDTO.getContent()!=null && !postDTO.getContent().isEmpty()) {
				postTbl.setContent(postDTO.getContent());
			}
			
			if(postDTO.getImageName()!=null && !postDTO.getImageName().isEmpty()) {
				postTbl.setImageName(postDTO.getImageName());
			}
			
			if(postDTO.getPostTitle()!=null && !postDTO.getPostTitle().isEmpty()) {
				postTbl.setPostTitle(postDTO.getPostTitle());
			}
			
			postRepo.save(postTbl);
			postDTO.setMessage("Updated Successfully");
		}
		
	}


	public void deletePost(PostDTO postDTO, int postId) {
		PostTbl postTbl = postRepo.findById(postId).orElse(null);
		if(postTbl!=null) {
			postRepo.delete(postTbl);
			postDTO.setMessage("Deleted Successfully");
		}
		
	}


	public void getAllPost(PostDTO postDTO) {
		List<PostTbl> postTbls = postRepo.findAll();
		
	}
	
	

}
