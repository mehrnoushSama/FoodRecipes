package com.sama.foodrecipes.requests.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sama.foodrecipes.models.Recipe
import kotlinx.parcelize.Parcelize

@Parcelize
class RecipeSearchResponse(
    @SerializedName("count")
    private var count: Int,
    @SerializedName("next")
    private var next: String,
    @SerializedName("previous")
    private var previous: String,
    @SerializedName("results")
    private var results: List<Recipe>,

    ) : Parcelable {

    override fun toString(): String {
        return "RecipeSearchResponse(count=$count, next='$next', previous='$previous', results=$results)"
    }
}