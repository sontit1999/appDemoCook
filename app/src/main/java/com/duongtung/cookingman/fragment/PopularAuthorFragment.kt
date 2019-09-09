package com.duongtung.cookingman.fragment

import com.duongtung.cookingman.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentPopularAuthorBinding

public class PopularAuthorFragment : BaseFragment<FragmentPopularAuthorBinding,PopularAuthorViewModel>(){
    override fun getClassViewMode() = PopularAuthorViewModel::class.java

    override fun setBindingViewModel() {
         binding.viewModel = viewModel
         binding.recyclerviewPopularAuthor.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun viewCreated() {
        viewModel.getArrPerson().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_popular_author

}