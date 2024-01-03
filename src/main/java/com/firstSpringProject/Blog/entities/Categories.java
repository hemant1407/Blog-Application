package com.firstSpringProject.Blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId")
	private int categoryId;
	
	@Column(name="categoryTitle")
	private String categoryTitle;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	private List<PostTbl> posts = new ArrayList<>();
	
	public Categories() {
		super();
	}

	@Column(name="categoryDiscription")
	private String categoryDiscription;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDiscription() {
		return categoryDiscription;
	}

	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}

	public Categories(int categoryId) {
		super();
		this.categoryId = categoryId;
	}
	
	
}
