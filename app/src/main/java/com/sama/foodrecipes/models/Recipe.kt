package com.sama.foodrecipes.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class Recipe(
    @SerializedName("title")
    var title: String,
    @SerializedName("publisher")
    var publisher: String? = null,
    @SerializedName("ingredients")
    var ingredients: Array<String>? = null,
    @SerializedName("featured_image")
    var featured_image: String? = null,
    @SerializedName("rating")
    var rating: Int? = null,
    @SerializedName("pk")
    var pk: Int? = null,
) : Parcelable {


    override fun toString(): String {
        return "Recipe(title='$title', publisher='$publisher', ingredients=${ingredients.contentToString()}, featured_image='$featured_image', rating=$rating, pk=$pk)"
    }
}