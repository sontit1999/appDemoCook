package com.duongtung.cookingman.model

data class Post(var user:User, var recipe: RecipeFood, var location: String, var time: String,var arrComment:List<Comment>)
