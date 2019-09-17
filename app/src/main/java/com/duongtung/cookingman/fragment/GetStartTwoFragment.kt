package com.duongtung.cookingman.fragment

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragGetstarttwoBinding

class GetStartTwoFragment :BaseFragment<FragGetstarttwoBinding,GetStartTwoViewModel>(){
    override fun getClassViewMode() = GetStartTwoViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_getstarttwo

}