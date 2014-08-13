package com.aoeng.data.fastjson;

import java.util.List;

public class Category1 {

	private String categoryId;
	private String name;
	private List<Category1> commCategoryDtos;
	

	public Category1() {
		super();
	}

	public Category1(String categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category1> getCommCategoryDtos() {
		return commCategoryDtos;
	}

	public void setCommCategoryDtos(List<Category1> commCategoryDtos) {
		this.commCategoryDtos = commCategoryDtos;
	}

	@Override
	public String toString() {
		return "Category1 [categoryId=" + categoryId + ", name=" + name + ", commCategoryDtos=" + commCategoryDtos + "]";
	}

}
