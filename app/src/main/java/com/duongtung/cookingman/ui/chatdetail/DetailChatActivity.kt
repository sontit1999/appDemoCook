package com.duongtung.cookingman.ui.chatdetail

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityDetailChatBinding

class DetailChatActivity : BaseActivity<ActivityDetailChatBinding, DetailChatViewModel>(){
    override fun getViewMode() = DetailChatViewModel::class.java

    override fun getLayout() = R.layout.activity_detail_chat

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
    }

}
