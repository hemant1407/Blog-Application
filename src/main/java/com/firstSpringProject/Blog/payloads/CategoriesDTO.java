package com.firstSpringProject.Blog.payloads;

public class CategoriesDTO extends RequestResponseDTO {
	
	private int categoryId;
	private String categoryTitle;
	private String categoryDiscription;
	
	
	public CategoriesDTO(int categoryId) {
		super();
		this.categoryId = categoryId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public CategoriesDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	
}
