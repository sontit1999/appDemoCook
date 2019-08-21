package com.duongtung.cookingman.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginVerifyBinding

class VerifyFragment : BaseFragment<FragLoginVerifyBinding,VerifyViewModel>(){
    override fun getClassViewMode() = VerifyViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {

    }

    override fun getLayoutId() = R.layout.frag_login_verify
}