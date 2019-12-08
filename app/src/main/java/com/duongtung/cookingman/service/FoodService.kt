package com.duongtung.cookingman.service

import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe
import com.duongtung.cookingman.model.login.Login
import com.duongtung.cookingman.model.login.LoginRes
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodService{
    @GET("post")
    fun login(@Body login : Login) : Observable<LoginRes>
    @GET("post")
    fun getPost() : Observable<MutableList<Postres>>
}