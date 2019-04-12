package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(SUPPORTS)
@Default
public class RecipeRepositoryDB implements RecipeRepository {

	@PersistenceContext
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		Recipe aRecipe = util.getObjectForJSON(recipe, Recipe.class);
		manager.persist(aRecipe);
		return "{\"message\": \"movie has been sucessfully added\"}";

	}

	@Override
	public String getAllRecipe() {
		Query query = manager.createQuery("Select r FROM Recipe r");
		Collection<Recipe> recipe = (Collection<Recipe>) query.getResultList();

		// manager.find(Movie.class, 1L);

		return util.getJSONForObject(recipe);
	}

	@Override
	public String getARecipe(Long id) {
		// TODO Auto-generated method stub
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}

	@Override
	public String updateRecipe(String show, Long id) {

		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipe recipe = util.getObjectForJSON(getARecipe(id), Recipe.class);

		if (manager.contains(manager.find(Recipe.class, id))) {

			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"recipe sucessfully deleted\"}";
	}

	@Override
	public int cycleRecipe(String title) {
		Query query = manager.createQuery("Select r FROM Recipe r");
		Collection<Recipe> recipe = (Collection<Recipe>) query.getResultList();

		List<Recipe> validList = recipe.stream().filter(n -> n.getTitle().equals(title)).collect(Collectors.toList());

		return validList.size();

	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
