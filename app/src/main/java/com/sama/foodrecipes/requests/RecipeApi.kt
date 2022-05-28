package com.sama.foodrecipes.requests

import com.sama.foodrecipes.requests.response.RecipeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("/api/recipe/search")
    fun searchRecipe(
        @Query("page") page: String,
        @Query("query") query: String
    ): Call<RecipeSearchResponse>


}