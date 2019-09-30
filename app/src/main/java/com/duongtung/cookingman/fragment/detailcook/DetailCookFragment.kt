package com.duongtung.cookingman.fragment.detailcook

import android.app.Activity
import android.content.Context
import android.util.Log
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentDetailCookBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener


class DetailCookFragment : BaseFragment<FragmentDetailCookBinding, DetailCookViewModel>() {
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }

    override fun getClassViewMode() = DetailCookViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
    }

    override fun viewCreated() {
    }

    override fun getLayoutId()=R.layout.fragment_detail_cook
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}
