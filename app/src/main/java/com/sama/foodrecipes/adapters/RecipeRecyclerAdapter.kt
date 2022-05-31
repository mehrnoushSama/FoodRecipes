package com.sama.foodrecipes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sama.foodrecipes.R
import com.sama.foodrecipes.models.Recipe

class RecipeRecyclerAdapter(onRecipeListener: OnRecipeListener) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    private var mRecipes: List<Recipe>? = null
    private var onRecipeListener: OnRecipeListener = onRecipeListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, onRecipeListener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = mRecipes!![position]
        holder.apply {
            title!!.text = currentItem.title
            publisher!!.text = currentItem.publisher
            socialScore!!.text = currentItem.rating.toString()


            val requestOption = RequestOptions().placeholder(R.drawable.ic_launcher_background)

            Glide.with(holder.itemView.context)
                .setDefaultRequestOptions(requestOption)
                .load(mRecipes!![position].featured_image)
                .into(holder.image as ImageView)

        }

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

}