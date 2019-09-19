package com.duongtung.cookingman.fragment

import com.duongtung.cookingman.base.ui.base.BaseViewModel

class DirectionViewModel : BaseViewModel(){
        var step1 = " Boil Water. Load the boiler pot with water and get it boiling. ..."
        var step2 = " Cook Hot Dog and Bun. Put the hot dog in the boiling water. ..."
        var step3 = " Chop Onions. Observe the magic onion-chopping trick! ..."
        var step4 = " Serve. 8 More Images. ..."
        var step5 = " Write / Eat. You're done! ..."
        var listStep = listOf(step1,step2,step3,step4,step5)

}