package com.duongtung.cookingman.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginVerifyBinding

class VerifyFragment : BaseFragment<FragLoginVerifyBinding,VeriftViewModel>(){
    override fun getClassViewMode() = VeriftViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_login_verify
}