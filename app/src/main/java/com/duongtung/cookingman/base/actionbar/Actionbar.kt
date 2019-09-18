package com.duongtung.cookingman.base.actionbar

import com.duongtung.cookingman.R

data class Actionbar(
    var title: String?,
    var leftButtonImage: String?,
    var rightButtonImage: String?,
    var backgroundActionBar: Int? = R.color.colorActionbar,
    var leftTitle : String?,
    var rightTitle : String?,
    var subRightImage : String?,
    var imageCollapsing : Int? = R.drawable.gaixinh
)