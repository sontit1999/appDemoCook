package com.duongtung.cookingman.fragment

import android.content.Intent
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding
import com.duongtung.cookingman.ui.MainActivity
import com.duongtung.cookingman.ui.MapsActivity

class NewFeedsFragment : BaseFragment<FragmentNewfeedsBinding, NewFeedsViewModel>() {
    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })

    }

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
    }

    override fun getClassViewMode() = NewFeedsViewModel::class.java

    override fun getLayoutId() = R.layout.fragment_newfeeds
}