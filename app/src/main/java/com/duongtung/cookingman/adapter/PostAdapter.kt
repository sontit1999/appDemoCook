package com.duongtung.cookingman.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemPostBinding
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres

class PostAdapter : BaseAdapter<Postres,ItemPostBinding>(){
    private var callBack : PostCallback?= null

    fun setCallBack( callBack: PostCallback?){
        this.callBack = callBack
    }

    override fun getOnClick()= callBack

    override fun getIdVariableOnClick() = BR.callback

    override fun getLayoutId() = R.layout.item_post

    override fun getIdVariable()= BR.post
}