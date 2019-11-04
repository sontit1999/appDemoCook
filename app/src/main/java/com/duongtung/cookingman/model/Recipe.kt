package com.duongtung.cookingman.model

import com.duongtung.cookingman.base.repository.data.DataRespond

data class Recipe(val name : String,val describe : String,val linkimg:String,val linkdetail:String,val idauthor: Int,val nameauthor:String) :
    DataRespond()