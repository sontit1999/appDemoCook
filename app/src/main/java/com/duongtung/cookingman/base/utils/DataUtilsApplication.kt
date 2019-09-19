package com.duongtung.cookingman.base.utils

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.actionbar.Actionbar

object DataUtilsApplication{
    @JvmStatic
    fun createActionBarLeftArrow(title : String?,context : Context) : Actionbar{
        return Actionbar(title = title, leftButtonImage =  context.getString(R.string.icon_arrow_left),
            rightButtonImage = null , backgroundActionBar = ContextCompat.getColor(context,R.color.colorAccent),
            leftTitle = null,rightTitle = null,subRightImage = null,imageCollapsing = null)

    }
    @JvmStatic
    fun createActionBarHome(title : String?,imageCollapsing: Int,context : Context): Actionbar{
        return Actionbar(title = title, leftButtonImage =  context.getString(R.string.icon_menu),
            rightButtonImage = context.getString(R.string.icon_search) , backgroundActionBar = Color.TRANSPARENT,
            leftTitle = null,rightTitle = null,subRightImage = null,imageCollapsing = imageCollapsing)
    }
}