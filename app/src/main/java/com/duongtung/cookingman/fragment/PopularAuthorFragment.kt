package com.duongtung.cookingman.fragment

import android.content.Intent
import com.duongtung.cookingman.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentPopularAuthorBinding
import com.duongtung.cookingman.ui.chatdetail.DetailChatActivity

public class PopularAuthorFragment : BaseFragment<FragmentPopularAuthorBinding,PopularAuthorViewModel>(){
    override fun getClassViewMode() = PopularAuthorViewModel::class.java

    override fun setBindingViewModel() {
         binding.viewModel = viewModel
    }

    override fun viewCreated() {
        viewModel.getArrPerson().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_popular_author

}