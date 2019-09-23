package com.duongtung.cookingman.fragment.profile

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragProfileBinding

class ProfileFragment  : BaseFragment<FragProfileBinding,ProfileViewModel>(){
    override fun getClassViewMode()  = ProfileViewModel::class.java

        override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
       viewModel.getArrRecipe().observe(this, Observer { list->
           viewModel.adapter.setList(list)
       })
    }

    override fun getLayoutId() = R.layout.frag_profile

}