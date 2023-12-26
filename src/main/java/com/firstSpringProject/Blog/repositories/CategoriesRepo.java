package com.firstSpringProject.Blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstSpringProject.Blog.entities.Categories;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Integer>{

}
