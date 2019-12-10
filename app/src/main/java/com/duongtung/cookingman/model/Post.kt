package com.duongtung.cookingman.model
import android.graphics.Color
import android.graphics.Typeface
import android.os.Parcel
import android.os.Parcelable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import java.io.Serializable

data class Post(var user:User, var recipe: RecipeFood, var location: String, var time: String,var arrComment:List<Comment>,var content:String)