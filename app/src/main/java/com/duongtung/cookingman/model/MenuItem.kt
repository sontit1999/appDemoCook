package com.duongtung.cookingman.model

import com.duongtung.cookingman.base.adapter.DataAdapter

data class MenuItem(val id : Int, val icon : String, val  title : String,var isSelected : Boolean,
                    override var viewType: Int
) : DataAdapter()