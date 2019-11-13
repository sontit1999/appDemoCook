package com.duongtung.cookingman.model.login

import com.duongtung.cookingman.base.repository.data.DataRespond

data class UserLoginRes(val id : Int, val type : Int, val phoneNumber : String, val email : String) : DataRespond()