package com.sama.foodrecipes.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sama.foodrecipes.models.Recipe
import com.sama.foodrecipes.repositories.RecipeRepository

//ViewModel vs AndroidViewModel -> if we need application must use AndroidViewModel

class RecipeListViewModel() : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository()

    fun getRecipe(): MutableLiveData<List<Recipe>> {
        return recipeRepository.getRecipes()
    }
    
    fun searchRecipesApi(query: String, pageNumber: Int) {
        recipeRepository.searchRecipesApi(query, pageNumber)

    }


}