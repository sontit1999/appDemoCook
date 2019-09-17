package com.duongtung.cookingman.model

import java.io.Serializable

data class Comment(var id:Int,var user:User,var content:String, var numberStar:String)