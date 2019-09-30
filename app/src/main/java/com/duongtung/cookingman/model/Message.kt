package com.duongtung.cookingman.model

import com.duongtung.cookingman.base.adapter.DataAdapter

data class Message(val message : String, val user : User, val  at : String,
                    override var viewType: Int?, override var groupType: Int? = 0
) : DataAdapter()
