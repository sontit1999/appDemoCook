package com.duongtung.cookingman.fragment.verify

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.customview.pinview.PinView
import com.duongtung.cookingman.databinding.FragLoginVerifyBinding
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener

class VerifyFragment : BaseFragment<FragLoginVerifyBinding, VerifyViewModel>(){
    override fun getClassViewMode() = VerifyViewModel::class.java
    private var mOnButtonClickListener: OnButtonClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnButtonClickListener = context as OnButtonClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        binding.viewmodel!!.onButtonClickListener = mOnButtonClickListener
    }

    override fun getLayoutId() = R.layout.frag_login_verify
}