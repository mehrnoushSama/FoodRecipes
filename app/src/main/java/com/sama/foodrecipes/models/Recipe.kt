package com.sama.foodrecipes.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class Recipe(
    @SerializedName("title")
    private var title: String,
    @SerializedName("publisher")
    private var publisher: String,
    @SerializedName("ingredients")
    private var ingredients: Array<String>,
    @SerializedName("featured_image")
    private var featured_image: String,
    @SerializedName("rating")
    private var rating: Int,
    @SerializedName("pk")
    private var pk: Int,
) : Parcelable {

    override fun toString(): String {
        return "Recipe(title='$title', publisher='$publisher', ingredients=${ingredients.contentToString()}, featured_image='$featured_image', rating=$rating, pk=$pk)"
    }
}