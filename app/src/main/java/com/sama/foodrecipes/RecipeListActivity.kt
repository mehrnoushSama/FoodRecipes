package com.sama.foodrecipes

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sama.foodrecipes.adapters.OnRecipeListener
import com.sama.foodrecipes.adapters.RecipeRecyclerAdapter
import com.sama.foodrecipes.viewModels.RecipeListViewModel

class RecipeListActivity : BaseActivity(), OnRecipeListener {

    private lateinit var recipeListViewModel: RecipeListViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter: RecipeRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        mRecyclerView = findViewById(R.id.recipe_list)

        recipeListViewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]
        initRecyclerView()
        subscribeObservers()
        initSearchView()
        getRecipe()

    }

    private fun initSearchView() {
        val searchView = findViewById<SearchView>(R.id.search_View)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.displayLoading()
                recipeListViewModel.searchRecipesApi(query as String, 1)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }


    private fun initRecyclerView() {
        adapter = RecipeRecyclerAdapter(this)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

    }


    private fun subscribeObservers() {
        recipeListViewModel.getRecipe().observe(this, Observer {

            adapter.setRecipes(it)
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

    override fun onRecipeClick(position: Int) {

    }

    override fun onCategoryClick(category: String) {

    }
}