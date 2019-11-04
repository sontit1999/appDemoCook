package com.duongtung.cookingman.service

import com.duongtung.cookingman.model.Recipe
import io.reactivex.Observable
import retrofit2.http.GET

interface RecipeAPIs {
    @GET("getRecipe.php")
    fun getDataRecipe() : Observable<MutableList<Recipe>>
}
