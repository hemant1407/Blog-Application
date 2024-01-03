package com.firstSpringProject.Blog.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PostTbl")
@Getter
@Setter
@NoArgsConstructor
public class PostTbl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
	@Column(name="post_title")
	private String postTitle;
	
	@Column(name="content")
	private String content;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;
	
	@ManyToOne
	private User user;
	
}
