package com.duongtung.cookingman.fragment.verify

import android.util.Log
import android.view.View
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.customview.pinview.PinView
import com.duongtung.cookingman.databinding.FragLoginVerifyBinding

class VerifyFragment : BaseFragment<FragLoginVerifyBinding, VerifyViewModel>(){
    override fun getClassViewMode() = VerifyViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }
    fun onHandleComplete(view : PinView){
        Log.d("onComplete", ""+ view.text.toString())
    }
    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_login_verify
}