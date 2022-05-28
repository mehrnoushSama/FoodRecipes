package com.sama.foodrecipes.requests.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sama.foodrecipes.models.Recipe
import kotlinx.parcelize.Parcelize

@Parcelize
class RecipeResponse(
    @SerializedName("recipe")
    private var recipe: Recipe,


    ) : Parcelable {
    override fun toString(): String {
        return "RecipeResponse(recipe=$recipe)"
    }
}