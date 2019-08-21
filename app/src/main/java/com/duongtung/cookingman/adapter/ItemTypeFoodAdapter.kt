package com.duongtung.cookingman.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.databinding.ItemRecycleTypeBinding
import com.duongtung.cookingman.model.TypeFood


class ItemTypeFoodAdapter : BaseAdapter<TypeFood,ItemRecycleTypeBinding>() {
    override fun getLayoutId() = R.layout.item_recycle_type

    override fun getIdVariable() = BR.typefood
}

