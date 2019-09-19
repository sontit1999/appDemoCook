package com.duongtung.cookingman.model

import java.io.Serializable

data class Comment(var id:Int,var user:User,var content:String, var numberStar:String){
    fun star():String{
        var string = ""
        var numberstar = numberStar.toInt()
        for(i in 1..numberstar)
            string+= "&#xf005;"

        return "&#xf005;"
    }
}