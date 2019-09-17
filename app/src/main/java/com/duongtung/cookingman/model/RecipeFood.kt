package com.duongtung.cookingman.model

import java.io.Serializable

data class RecipeFood(var nameFood:String,var imageRecipe:String,var arrIngredient:List<FoodIngredient>,var stepToMake:String)