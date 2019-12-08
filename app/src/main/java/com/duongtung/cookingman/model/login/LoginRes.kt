package com.duongtung.cookingman.model.login

import com.duongtung.cookingman.base.repository.data.DataRespond
import java.io.Serializable


data class LoginRes(val status: String,val id : String, val emails : String, val passwords : String, val nickname :String,val description:String, val linkavatar:String , val linkcover:String) : Serializable