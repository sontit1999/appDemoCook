package com.duongtung.cookingman.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.R

class TypeFoodholder(itemView : View?) : RecyclerView.ViewHolder(itemView!!) {
    var txtTitle : TextView = itemView!!.findViewById(R.id.txtType)
    var txtDescrible : TextView = itemView!!.findViewById(R.id.txtDescrible)
    var imgbtnadd : ImageView = itemView!!.findViewById(R.id.imgBtnadd)
    var imgTypeFood : ImageView = itemView!!.findViewById(R.id.imgTypeFood)
}