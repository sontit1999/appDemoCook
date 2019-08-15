package com.duongtung.cookingman.base.utils

import android.graphics.Color
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.actionbar.Actionbar

object DataUtilsApplication{
    @JvmStatic
    fun CreateActionBarHome(title : String) : Actionbar{
        var actionBar = Actionbar(title = title, leftButtonImage =  R.drawable.ic_launcher_background,
            rightButtonImage = 0, backgroundActionBar = Color.WHITE,leftTitle = 0,rightTitle = 0)
        return actionBar
    }
}