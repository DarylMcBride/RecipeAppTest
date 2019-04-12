package com.qab.business.service;

public interface RecipeService {
	
	//C
		String addRecipe(String recipe);
		
		//R
		String getAllRecipe();
		
		String getARecipe(Long id);

		//U
		String updateRecipe(String recipe, Long id);

		//D
		String deleteRecipe(Long id);
		
		int cycleRecipe(String recipe);


}
