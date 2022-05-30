package com.sama.foodrecipes.requests

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sama.foodrecipes.AppExecuters
import com.sama.foodrecipes.models.Recipe
import com.sama.foodrecipes.requests.response.RecipeSearchResponse
import com.sama.foodrecipes.util.Constants.Companion.NETWORK_TIME_OUT
import retrofit2.Call
import java.util.concurrent.TimeUnit

class RecipeApiClient {

    var mRecipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    private var mRetrieveRecipeRunnable: RetrieveRecipesRunnable? = null
    private val mRecipeRequestTimeout = MutableLiveData<Boolean>()

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
    fun searchRecipeApi(query: String, pageNumber: Int) {
        if (mRetrieveRecipeRunnable != null) {
            mRetrieveRecipeRunnable = null
        }
        mRetrieveRecipeRunnable = RetrieveRecipesRunnable(query, pageNumber)
        val handler = AppExecuters.getInstance().networkIO().submit(mRetrieveRecipeRunnable)

        mRecipeRequestTimeout.postValue(true);
        AppExecuters.getInstance().networkIO().schedule(Runnable {
            handler.cancel(true)

        }, NETWORK_TIME_OUT, TimeUnit.MILLISECONDS)

    }


    private inner class RetrieveRecipesRunnable(
        private val query: String,
        private val pageNumber: Int
    ) : Runnable {
        private val cancelRequest: Boolean = false
        private val TAG = "RecipeApiClient"
        override fun run() {
            val response = getRecipes(query, pageNumber).execute()
            if (cancelRequest) {
                return
            }
            if (response.code() == 200) {
                val list = (response.body()!!.geRecipes())
                if (pageNumber == 1) {
                    mRecipes.postValue(list)
                } else {
                    var currentRecipes: ArrayList<Recipe> = mRecipes.value as ArrayList<Recipe>
                    currentRecipes.addAll(list)
                }
            } else {
                val error = response.errorBody().toString()
                Log.d(TAG, error)
            }
        }

        private fun getRecipes(
            query: String, pageNumber: Int
        ): Call<RecipeSearchResponse> {

            return ServiceGenerator.getRecipeApi().searchRecipe(query, pageNumber.toString())

        }

        private fun cancelRequest() {
            Log.d(TAG, "cancel Request")

        }

    }


}