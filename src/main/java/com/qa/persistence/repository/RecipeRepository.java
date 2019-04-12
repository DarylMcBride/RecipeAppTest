package com.qa.persistence.repository;

public interface RecipeRepository {
	
		//C
		String createRecipe(String recipe);
		
		//R
		String getAllRecipe();
		
		String getARecipe(Long id);
		
		//U
		String updateRecipe(String recipe, Long id);

		//D
		String deleteRecipe(Long id);
		
		int cycleRecipe(String title);


}
