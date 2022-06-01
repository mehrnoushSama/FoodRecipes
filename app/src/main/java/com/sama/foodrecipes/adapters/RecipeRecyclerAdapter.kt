package com.sama.foodrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sama.foodrecipes.R
import com.sama.foodrecipes.models.Recipe
import java.util.*
import kotlin.collections.ArrayList

class RecipeRecyclerAdapter(onRecipeListener: OnRecipeListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mRecipes: List<Recipe>? = null
    private var onRecipeListener: OnRecipeListener = onRecipeListener

    private companion object {
        const val RECIPE_TYPE = 1
        const val LOADING_TYPE = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var view: View
        when (viewType) {
            RECIPE_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_recipe_list_item, parent, false)
                return RecipeViewHolder(view, onRecipeListener)
            }
            LOADING_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.loading_list_item, parent, false)
                return LoadingViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_recipe_list_item, parent, false)
                return RecipeViewHolder(view, onRecipeListener)
            }

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var itemViewType = getItemViewType(position)
        if (itemViewType == RECIPE_TYPE) {
            val currentItem = mRecipes!![position]
            (holder as RecipeViewHolder).title!!.text = currentItem.title
            (holder as RecipeViewHolder).publisher!!.text = currentItem.publisher
            (holder as RecipeViewHolder).socialScore!!.text = currentItem.rating.toString()

            val requestOption = RequestOptions().placeholder(R.drawable.ic_launcher_background)

            Glide.with(holder.itemView.context)
                .setDefaultRequestOptions(requestOption)
                .load(mRecipes!![position].featured_image)
                .into(holder.image as ImageView)


        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (mRecipes!![position].title == "LOADING...")
            LOADING_TYPE
        else
            RECIPE_TYPE
    }

    fun displayLoading() {

        if (!isLoading()) {
            val recipe = Recipe("LOADING...")
            val loadingList = ArrayList<Recipe>()
            loadingList.add(recipe)
            mRecipes = loadingList
            notifyDataSetChanged()
        }
    }

    private fun isLoading(): Boolean {
        if (mRecipes!!.isNotEmpty()) {
            if (mRecipes!![mRecipes!!.size - 1].title == "LOADING...")
                return true
        }
        return false
    }

    override fun getItemCount(): Int {
        if (mRecipes != null)
            return mRecipes!!.size
        return 0
    }


    fun setRecipes(recipes: List<Recipe>) {
        mRecipes = recipes
        notifyDataSetChanged()
    }

//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }

}