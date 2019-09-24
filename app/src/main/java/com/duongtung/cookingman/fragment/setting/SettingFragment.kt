package com.duongtung.cookingman.fragment.setting

import android.app.Activity
import android.content.Context
import android.util.Log
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentSettingBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener

class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment chat")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = SettingViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
    }

    override fun viewCreated() {
    }

    override fun getLayoutId() = R.layout.fragment_setting
    override fun onResume() {
        super.onResume()
        this.actionBarHomeOnClick!!.onResumeFragment(this)
    }
}