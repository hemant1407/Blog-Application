package com.firstSpringProject.Blog.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO extends RequestResponseDTO{
	
	private int postId;
	private String postTitle;
	private String content;
	private String imageName;
	private Date addedDate;
	private int userId;
	private int categoryId;
}
