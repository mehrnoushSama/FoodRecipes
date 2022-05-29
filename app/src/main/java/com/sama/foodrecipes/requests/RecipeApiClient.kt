package com.sama.foodrecipes.requests

import androidx.lifecycle.MutableLiveData
import com.sama.foodrecipes.AppExecuters
import com.sama.foodrecipes.models.Recipe
import com.sama.foodrecipes.repositories.RecipeRepository
import com.sama.foodrecipes.util.Constants
import com.sama.foodrecipes.util.Constants.Companion.NETWORK_TIME_OUT
import java.util.concurrent.TimeUnit

class RecipeApiClient {
    private var mRecipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    companion object {
        private lateinit var instance: RecipeApiClient
        fun getInstance(): RecipeApiClient {
            if (instance == null) {
                instance = RecipeApiClient()
            }
            return instance
        }
    }

    fun getRecipes(): MutableLiveData<List<Recipe>> {
        return mRecipes
    }


    //request to server
    fun searchRecipeApi() {

        val handler = AppExecuters.getInstance().networkIO().submit(Runnable {
//            mRecipes.postValue()

        })

        AppExecuters.getInstance().networkIO().schedule(Runnable {
            handler.cancel(true)
        }, NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)

    }


    private class RetrieveRecipesRunnable(


    ):Runnable {
        override fun run() {
            TODO("Not yet implemented")
        }

    }


}