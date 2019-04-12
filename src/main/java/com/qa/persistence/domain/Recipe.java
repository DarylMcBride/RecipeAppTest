package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String title;
	private String ingredients;
	private String cookingMethod;

	public Recipe() {

	}

	public Recipe(String title, String ingredients, String cookingMethod) {
		this.title = title;
		this.ingredients = ingredients;
		this.cookingMethod = cookingMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCookingMethod() {
		return cookingMethod;
	}

	public void setCookingMethod(String cookingMethod) {
		this.cookingMethod = cookingMethod;
	}



}
