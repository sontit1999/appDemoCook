package com.duongtung.cookingman.pref

import android.content.Context
import com.duongtung.cookingman.base.repository.utils.PrefUtils

class PrefCookingMan : PrefUtils(){
    companion object{
        fun accessToken(context: Context, accessToken: String) {
            val editor = getSharedPreferences(context).edit()
            editor.putString("ACCESS_TOKEN", accessToken)
            editor.apply()
        }

        fun getAccessToken(context: Context): String? {
            return getSharedPreferences(context).getString("ACCESS_TOKEN", null)
        }
    }

}