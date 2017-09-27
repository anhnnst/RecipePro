package com.loabten.recipe.services;

import com.loabten.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService
{
    Set<Recipe> getRecipes();
}
