package com.duongtung.cookingman.fragment.detailchat

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragDetailChatBinding

class DetailChatFragment : BaseFragment<FragDetailChatBinding,DetailChatViewModel>() {
    override fun getClassViewMode() = DetailChatViewModel::class.java

    override fun setBindingViewModel() {
          binding.viewmodel = viewModel
    }

    override fun viewCreated() {
              viewModel.getArrMessage().observe(this, Observer { list->
                  viewModel.adapter.setList(list)
              })
    }

    override fun getLayoutId() = R.layout.frag_detail_chat
}