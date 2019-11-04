package com.duongtung.cookingman.callback;

import com.duongtung.cookingman.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeAPIs {
    @GET("getRecipe.php")
    Call<List<Recipe>> getdataRecipe();
}
