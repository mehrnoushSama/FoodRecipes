package com.sama.foodrecipes.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.sama.foodrecipes.R

class RecipeViewHolder(itemView: View, onRecipeListener: OnRecipeListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var title: TextView? = null
    var publisher: TextView? = null
    var socialScore: TextView? = null
    var image: ImageView? = null
    var onRecipeListener: OnRecipeListener? = onRecipeListener

    init {
        title = itemView.findViewById(R.id.recipe_title)
        publisher = itemView.findViewById(R.id.recipe_publisher)
        socialScore = itemView.findViewById(R.id.recipe_social_score)
        image = itemView.findViewById(R.id.recipe_image)
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onRecipeListener!!.onRecipeClick(absoluteAdapterPosition)

    }
}