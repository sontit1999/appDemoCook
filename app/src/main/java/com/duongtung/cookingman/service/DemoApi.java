package com.duongtung.cookingman.service;

import com.duongtung.cookingman.model.Postres;
import com.duongtung.cookingman.model.ResponLog;
import com.duongtung.cookingman.model.login.LoginRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DemoApi {
    @GET("newfeed.php")
    Call<List<Postres>> getPost();
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginRes> login(@Field("email") String email, @Field("pass") String pass);
}
