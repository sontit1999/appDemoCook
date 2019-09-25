package com.duongtung.cookingman.base.actionbar

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
    var imageCollapsing : Int? = null
)