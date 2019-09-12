package com.duongtung.cookingman.fragment

import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragGetstartoneBinding

class GetStartOneFragment : BaseFragment<FragGetstartoneBinding,GetStartOneViewModel>(){
    override fun getClassViewMode() = GetStartOneViewModel::class.java

    override fun setBindingViewModel() {
       binding.viewmodel = viewModel
    }

    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_getstartone

}