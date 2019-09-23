package com.duongtung.cookingman.fragment.profile

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragProfileBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener

class ProfileFragment  : BaseFragment<FragProfileBinding,ProfileViewModel>(){
    override fun getClassViewMode()  = ProfileViewModel::class.java
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment profile")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
        override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
       viewModel.getArrRecipe().observe(this, Observer { list->
           viewModel.adapter.setList(list)
       })
    }

    override fun getLayoutId() = R.layout.frag_profile
    override fun onResume() {
        Log.d("test","on resume profile frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}