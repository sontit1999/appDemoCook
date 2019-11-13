package com.duongtung.cookingman.model.login

import com.duongtung.cookingman.base.repository.data.DataRespond


data class LoginRes(val user : UserLoginRes, val access_token : String, val token_type : String, val expires_at :String): DataRespond()