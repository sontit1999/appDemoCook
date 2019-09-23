package com.duongtung.cookingman.fragment.home

import android.app.Activity
import android.content.Context
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = HomeFragmentViewModel::class.java

    override fun setBindingViewModel() {
        actionBarHomeOnClick!!.initFragment(this)
        binding.viewModel = viewModel
    }

    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId()= R.layout.fragment_home
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}