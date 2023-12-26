package com.firstSpringProject.Blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpringProject.Blog.entities.Categories;
import com.firstSpringProject.Blog.payloads.CategoriesDTO;
import com.firstSpringProject.Blog.payloads.RequestResponseDTO;
import com.firstSpringProject.Blog.repositories.CategoriesRepo;
import com.firstSpringProject.Blog.utils.Constants;

@Service
public class CategoriesService {
	
	@Autowired
	public CategoriesRepo categoriesRepo;

	public void addUpdateCategories(CategoriesDTO categoriesDTO) {

		if(categoriesDTO.getReqType()==Constants.req_type.ADD) {

			Categories categoriesTbl =new Categories();

//			categoriesTbl.setCategoryId(categoriesDTO.getCategoryId());
			categoriesTbl.setCategoryTitle(categoriesDTO.getCategoryTitle());
			categoriesTbl.setCategoryDiscription(categoriesDTO.getCategoryDiscription());
			
			categoriesRepo.save(categoriesTbl);

		}else {
			Categories categoriesTbl = categoriesRepo.findById(categoriesDTO.getCategoryId()).orElse(null);
			
			if(categoriesTbl==null) {
				categoriesDTO.setMessage("Category Id not present");
				return;
			}
			
//			categoriesTbl.setCategoryId(1);
			categoriesTbl.setCategoryTitle(categoriesDTO.getCategoryTitle());
			categoriesTbl.setCategoryDiscription(categoriesDTO.getCategoryDiscription());
			
			categoriesRepo.save(categoriesTbl);
		}
	}
	


}
