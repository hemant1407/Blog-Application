package com.firstSpringProject.Blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstSpringProject.Blog.entities.PostTbl;

@Repository
public interface PostRepo extends JpaRepository<PostTbl, Integer> {

}
