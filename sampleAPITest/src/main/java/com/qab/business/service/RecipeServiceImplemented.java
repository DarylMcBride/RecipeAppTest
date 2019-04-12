package com.qab.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.RecipeRepository;

public class RecipeServiceImplemented implements RecipeService {

	@Inject
	private RecipeRepository repo;

	public String getAllRecipe() {
		return repo.getAllRecipe();
	}

	@Override
	public String addRecipe(String recipe) {
		if (recipe.contains("bacon")) {
			return "can't add this recipe";
		}
		return repo.createRecipe(recipe);
	}

	@Override
	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

	@Override
	public int cycleRecipe(String title) {

		return repo.cycleRecipe(title);

	}

	@Override
	public String getARecipe(Long id) {
		return repo.getARecipe(id);

	}

	@Override
	public String updateRecipe(String recipe, Long id) {
		return repo.updateRecipe(recipe, id);
	}

}
