package com.duongtung.cookingman.adapter
import com.duongtung.cookingman.BR
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.adapter.BaseAdapter
import com.duongtung.cookingman.base.adapter.callback.CBAdapter
import com.duongtung.cookingman.databinding.ItemCommentBinding
import com.duongtung.cookingman.model.Comment

class CommentAdapter : BaseAdapter<Comment,ItemCommentBinding>(){
    override fun getOnClick(): CBAdapter? = null

    override fun getIdVariableOnClick(): Int? {
        return null
    }

    override fun getLayoutId() = R.layout.item_comment

    override fun getIdVariable() = BR.comment

}