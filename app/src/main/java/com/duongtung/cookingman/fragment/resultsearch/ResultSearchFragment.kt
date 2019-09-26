package com.duongtung.cookingman.fragment.resultsearch

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragResultSearchBinding

class ResultSearchFragment : BaseFragment<FragResultSearchBinding,ResultSearchViewModel>(){
    override fun getClassViewMode() = ResultSearchViewModel::class.java
    override fun setBindingViewModel() {
       binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId()= R.layout.frag_result_search

}