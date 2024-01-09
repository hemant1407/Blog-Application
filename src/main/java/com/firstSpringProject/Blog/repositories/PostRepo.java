package com.firstSpringProject.Blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstSpringProject.Blog.entities.Categories;
import com.firstSpringProject.Blog.entities.PostTbl;
import com.firstSpringProject.Blog.entities.User;

@Repository
public interface PostRepo extends JpaRepository<PostTbl, Integer> {

	List<PostTbl> findByCategory(Categories category);

	List<PostTbl> findByUser(User user);

}
