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
    @GET("drink.php")
    Call<List<Postres>> getDrink();
    @GET("foodspecial.php")
    Call<List<Postres>> getSpecialFood();
    @GET("getcomment.php")
    Call<List<Comment>> getComment(@Query("postid") String postid);
    @GET("getpost.php")
    Call<List<Postres>> getPostUser(@Query("id") String userid);
    @GET("getFavorite.php")
    Call<List<Postres>> getFavoritepost(@Query("id") String userid);
    @GET("search.php")
    Call<List<Postres>> searchPost(@Query("keyword") String keyword);
    @GET("getUser.php")
    Call<LoginRes> getUser(@Query("id") String userid);
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginRes> login(@Field("email") String email, @Field("pass") String pass);
    @FormUrlEncoded
    @POST("addFavorite.php")
    Call<String> addFavorite(@Field("iduser") String iduser, @Field("idpost") String idpost);
    @FormUrlEncoded
    @POST("deleteFavorite.php")
    Call<String> deleteFavorite(@Field("iduser") String iduser, @Field("idpost") String idpost);
    @FormUrlEncoded
    @POST("addcomment.php")
    Call<Comment> addComment(@Field("content") String content, @Field("postid") String postid,@Field("userid") String userid);
    @FormUrlEncoded
    @POST("addpost.php")
    Call<String> addpost(@Field("namereipe") String namereipe, @Field("caption") String caption,@Field("image") String image,@Field("ingredient") String ingredient,@Field("howtocook") String howtocook,@Field("userid") String userid,@Field("menuid") String menuid,@Field("timecomplete") String timecomplete);
    @FormUrlEncoded
    @POST("register.php")
    Call<String> Register(@Field("emails") String emails, @Field("passwords") String passwords,@Field("nickname") String nickname,@Field("description") String description,@Field("linkavatar") String linkavatar);
    @FormUrlEncoded
    @POST("upload.php")
    Call<String> upload(@Field("image") String stringImage);
    @FormUrlEncoded
    @POST("updateImage.php")
    Call<String> updateProfile(@Field("id") String id,@Field("type") String type,@Field("image") String image);
}
