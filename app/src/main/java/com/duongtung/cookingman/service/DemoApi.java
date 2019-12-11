package com.duongtung.cookingman.service;

import com.duongtung.cookingman.model.Comment;
import com.duongtung.cookingman.model.Postres;
import com.duongtung.cookingman.model.login.LoginRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DemoApi {
    @GET("newfeed.php")
    Call<List<Postres>> getPost();
    @GET("getcomment.php")
    Call<List<Comment>> getComment(@Query("postid") String postid);
    @GET("getpost.php")
    Call<List<Postres>> getPostUser(@Query("id") String userid);
    @GET("getUser.php")
    Call<LoginRes> getUser(@Query("id") String userid);
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginRes> login(@Field("email") String email, @Field("pass") String pass);
    @FormUrlEncoded
    @POST("addcomment.php")
    Call<Comment> addComment(@Field("content") String content, @Field("postid") String postid,@Field("userid") String userid);
}
