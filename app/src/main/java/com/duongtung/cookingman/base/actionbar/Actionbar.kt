package com.duongtung.cookingman.base.actionbar

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import com.duongtung.cookingman.CookingApplication
import com.duongtung.cookingman.R
import com.duongtung.cookingman.customview.imageslide.ItemImageSlide




data class Actionbar(
    var imageSlides: MutableList<ItemImageSlide>? = null,
    var title: String? = null,
    var leftButtonImage: String?= null,
    var rightButtonImage: String?= null,
    var backgroundActionBar: Int? = R.color.colorActionbar,
    var leftTitle : String?= null,
    var rightTitle : String?= null,
    var subRightImage : String?= null,
    var imageCollapsing : Int? = null,
    var imageTitle: String ?= null,
    var time : String ? = null,
    var cals : String ? = null,
    var rank : Float ? = 0f
){
    fun montarEstrellasValoracion() : Spannable {
        var result = ""
        val span : Spannable
        val fullRating =  CookingApplication.getResource().getString(R.string.icon_star_rating)
        val half  = CookingApplication.getResource().getString(R.string.icon_star_rating_half)
        val disableColor = CookingApplication.getResource().getColor(R.color.lighter_gray)
        val activeColor =  CookingApplication.getResource().getColor(R.color.yellow)
        when {
            rank!! == 0f -> {
                for (i in 0..5) {
                    result += fullRating
                }
                span = SpannableString(result)
                span.setSpan(ForegroundColorSpan(disableColor!!),0,result.length-1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            rank!! == 5f -> {
                span = SpannableString(result)
                span.setSpan(ForegroundColorSpan(activeColor!!),0,result.length-1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            else -> {
                var const = 1f
                var pos = 0
                while (const <= 5){

                    if((const+0.5f)<rank!! || (const+0.5f) >rank!!){
                        result+=fullRating
                        if (const == rank){
                            pos = const.toInt()
                        }
                        const++
                    }else {
                        pos = const.toInt()
                        result+=half
                        const++
                    }
                }
                span = SpannableString(result)
                span.setSpan(ForegroundColorSpan(activeColor!!),0,pos,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                span.setSpan(ForegroundColorSpan(disableColor!!),pos,result.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        return span
    }
}