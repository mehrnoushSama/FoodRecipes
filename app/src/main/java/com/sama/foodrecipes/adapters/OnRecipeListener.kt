package com.sama.foodrecipes.adapters

interface OnRecipeListener {
    fun onRecipeClick(position: Int)
    fun onCategoryClick(category: String)
}