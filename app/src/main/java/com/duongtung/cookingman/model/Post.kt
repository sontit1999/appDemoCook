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

data class Post(var user:User, var recipe: RecipeFood, var location: String, var time: String,var arrComment:List<Comment>,var content:String){
    fun infor() : SpannableStringBuilder{
        var start = 0
        var infor  = SpannableStringBuilder()
        infor.append(user.nickName)
        infor.setSpan(StyleSpan(Typeface.BOLD), start,infor.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        infor.setSpan(ForegroundColorSpan(Color.BLACK), start,infor.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = infor.length
        infor.append(" is making a ")
        infor.setSpan(ForegroundColorSpan(Color.parseColor("#616161")), start,infor.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        start = infor.length
        infor.append(recipe.nameFood)
        infor.setSpan(ForegroundColorSpan(Color.RED), start,infor.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        start = infor.length
        infor.append(" at $location ")
        infor.setSpan(ForegroundColorSpan(Color.parseColor("#616161")), start,infor.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return infor
    }
    fun otherpeople() : SpannableStringBuilder{
        var numbercomment = arrComment.size

        if(numbercomment == 0){
            var start = 0
            var otherPeople = SpannableStringBuilder()
            otherPeople.append("More 100 Idol joined")
            otherPeople.setSpan(ForegroundColorSpan(Color.parseColor("#616161")), start,otherPeople.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            start = otherPeople.length
            otherPeople.append(" EDACIOUS")
            otherPeople.setSpan(ForegroundColorSpan(Color.RED), start,otherPeople.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            return   otherPeople
        }
        var otherPeople1 = SpannableStringBuilder()
        for(i in 0..arrComment.size-1){
            if(i == arrComment.size-1){
                otherPeople1.append(arrComment.get(i).user.nickName)
                Log.d("test","pt cuối")
            }else{
                otherPeople1.append(arrComment.get(i).user.nickName).append(", ")
                Log.d("test","ko phải pt cuối")
            }
        }
        var start1 = 0
        otherPeople1.setSpan(StyleSpan(Typeface.BOLD), start1,otherPeople1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        otherPeople1.setSpan(ForegroundColorSpan(Color.BLACK), start1,otherPeople1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        start1 = otherPeople1.length
        otherPeople1.append(" joined ")
        otherPeople1.setSpan(ForegroundColorSpan(Color.parseColor("#616161")), start1,otherPeople1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        start1 = otherPeople1.length
        otherPeople1.append(" DALICIOUS ")
        otherPeople1.setSpan(ForegroundColorSpan(Color.RED), start1,otherPeople1.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return otherPeople1
    }
    fun peoplOne() : String{
        if(0 >= arrComment.size){
            //index not exists
            return  "http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-18.jpg"
        }else{
            // index exists
            return  arrComment.get(0).user.profileUrl
        }

    }
    fun peoplTwo() : String{
        if(1 >= arrComment.size){
            //index not exists
            return  "http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-18.jpg"
        }else{
            // index exists
            return  arrComment.get(1).user.profileUrl
        }

    }
    fun peopleThree() : String{
        if(2 >= arrComment.size){
            //index not exists
            return  "http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-18.jpg"
        }else{
            // index exists
            return  arrComment.get(2).user.profileUrl
        }
    }
    fun peopleFour() : String{
        if(3 >= arrComment.size){
            //index not exists
            return  "http://vinathis.com/news/uploads/news/2018_09/hinh-anh-gai-xinh-sexy-18.jpg"
        }else{
            // index exists
            return  arrComment.get(3).user.profileUrl
        }

    }
    fun more():String{
         if(arrComment.size>4) return "${arrComment.size - 4}+"
         return "69+"
    }
    fun creatRecipe():SpannableStringBuilder{
        var span = SpannableStringBuilder()
        var start = 0
        span.append(user.nickName)
        span.setSpan(ForegroundColorSpan(Color.RED), start,span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.append(" creat this recipe ")
        return span
    }

}
