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
    fun createActionBarHome(title: String?, imageCollapsing: Int?, rightBtn: String?,backgroundActionBar : Int?=Color.TRANSPARENT,context: Context): Actionbar{
        return Actionbar(title = title, leftButtonImage =  context.getString(R.string.icon_menu),
            rightButtonImage = rightBtn , backgroundActionBar = backgroundActionBar,
            leftTitle = null,rightTitle = null,subRightImage = null,imageCollapsing = imageCollapsing)
    }

    fun createActionBarBackPress(title: String?, imageCollapsing: Int?, rightBtn: String?,backgroundActionBar : Int?=Color.TRANSPARENT,context: Context): Actionbar{
        return Actionbar(title = title, leftButtonImage =  context.getString(R.string.icon_arrow_left),
            rightButtonImage = rightBtn , backgroundActionBar = backgroundActionBar,
            leftTitle = null,rightTitle = null,subRightImage = null,imageCollapsing = imageCollapsing)
    }
}