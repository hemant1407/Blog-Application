package com.firstSpringProject.Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpringProject.Blog.payloads.CategoriesDTO;
import com.firstSpringProject.Blog.payloads.RequestResponseDTO;
import com.firstSpringProject.Blog.services.CategoriesService;

@RestController
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;
	
	@PostMapping("/addUpdateCategories")
	public RequestResponseDTO addUpdateCategoriesDTO(@RequestBody CategoriesDTO categoriesDTO){
		categoriesService.addUpdateCategories(categoriesDTO);
		return categoriesDTO;
	}
}
