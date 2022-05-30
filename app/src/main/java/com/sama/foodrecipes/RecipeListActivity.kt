package com.sama.foodrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sama.foodrecipes.models.Recipe
import com.sama.foodrecipes.requests.ServiceGenerator
import com.sama.foodrecipes.requests.response.RecipeSearchResponse
import com.sama.foodrecipes.viewModels.RecipeListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class RecipeListActivity : BaseActivity() {

    private lateinit var recipeListViewModel: RecipeListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        subscribeObservers()
        findViewById<Button>(R.id.test).setOnClickListener {
            getRecipe()
//            if (mProgressBar!!.visibility == View.VISIBLE)
//                showProgressBar(false)
//            else
//                showProgressBar(true)
        }
    }


    private fun subscribeObservers() {

        recipeListViewModel.getRecipe().observe(this, Observer {
            val response = it
        })

    }

    private fun searchRecipesApi(query: String, pageNumber: Int) {
        recipeListViewModel.searchRecipesApi(query, pageNumber)

    }


    private fun getRecipe() {
        searchRecipesApi("chicken breast", 1)
//        val recipeApi = ServiceGenerator.getRecipeApi()
//        val response = recipeApi.searchRecipe("1", "chicken breast")
//        response.enqueue(object : Callback<RecipeSearchResponse> {
//            override fun onResponse(
//                call: Call<RecipeSearchResponse>,
//                response: Response<RecipeSearchResponse>
//            ) {
//                val res = response.toString()
//                val listRecipe = ArrayList<Recipe>(response.body()!!.geRecipes())
//            }
//
//            override fun onFailure(call: Call<RecipeSearchResponse>, t: Throwable) {
//                var err = t.toString()
//            }
//        })

    }
}