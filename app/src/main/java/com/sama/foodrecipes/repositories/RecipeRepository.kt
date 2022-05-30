package com.sama.foodrecipes.repositories

import androidx.lifecycle.MutableLiveData
import com.sama.foodrecipes.AppExecuters
import com.sama.foodrecipes.models.Recipe
import com.sama.foodrecipes.requests.RecipeApiClient

class RecipeRepository {

    private var recipeApiClient: RecipeApiClient = RecipeApiClient()

    companion object {
        private lateinit var instance: RecipeRepository
        fun getInstance(): RecipeRepository {
            if (instance == null) {
                instance = RecipeRepository()
            }
            return instance
        }
    }


    fun getRecipes(): MutableLiveData<List<Recipe>> {
        return recipeApiClient.getRecipes()
    }

    fun searchRecipesApi(query: String, pageNumber: Int) {
        recipeApiClient.searchRecipeApi(query, pageNumber)

    }


}