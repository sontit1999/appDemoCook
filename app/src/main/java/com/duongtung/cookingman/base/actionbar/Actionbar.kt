package com.duongtung.cookingman.base.actionbar

import com.duongtung.cookingman.R
import com.duongtung.cookingman.customview.imageslide.ItemImageSlide
import java.io.FileDescriptor

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
    var rank : Int ? = null
)