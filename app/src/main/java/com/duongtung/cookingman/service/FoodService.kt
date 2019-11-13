package com.duongtung.cookingman.service

import com.duongtung.cookingman.model.login.Login
import com.duongtung.cookingman.model.login.LoginRes
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface FoodService{
    @POST("login")
    fun login(@Body login : Login) : Observable<LoginRes>
}