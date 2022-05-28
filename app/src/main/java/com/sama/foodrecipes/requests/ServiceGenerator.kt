package com.sama.foodrecipes.requests

import com.sama.foodrecipes.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ServiceGenerator {

    companion object {
        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        private val retrofit: Retrofit = retrofitBuilder.build()
        private val recipeApi = retrofit.create(RecipeApi::class.java)

        fun getRecipeApi(): RecipeApi {
            return recipeApi
        }
    }
}