package com.duongtung.cookingman.model
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan

data class FoodIngredient(var nameIngredient : String,var imageIngredient : String, var number : String,var measure : String){
    fun number(): SpannableStringBuilder{
        var span = SpannableStringBuilder()
        var start = 0

        span.append(number).append("\n").append(measure)
        span.setSpan(ForegroundColorSpan(Color.BLACK), start,span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(StyleSpan(Typeface.BOLD), start,span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
       return span
    }
    fun number1(): SpannableStringBuilder{
        var span = SpannableStringBuilder()
        var start = 0
        span.append(number).append(" ").append(measure)
        span.setSpan(ForegroundColorSpan(Color.BLACK), start,span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(StyleSpan(Typeface.BOLD), start,span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return span
    }
}

