package com.sama.foodrecipes.requests

import com.sama.foodrecipes.requests.response.RecipeResponse
import com.sama.foodrecipes.requests.response.RecipeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeApi {

    @Headers("Authorization: Token 9c8b06d329136da358c2d00e76946b0111ce2c48")
    @GET("/api/recipe/search")
    fun searchRecipe(
        @Query("query") query: String,
        @Query("page") page: String

    ): Call<RecipeSearchResponse>

    @Headers("Authorization: Token 9c8b06d329136da358c2d00e76946b0111ce2c48")
    @GET("/api/recipe/get")
    fun getRecipe(
        @Query("id") id: String
    ): Call<RecipeResponse>


}