package com.duongtung.cookingman.fragment.home

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentHomeBinding
import com.duongtung.cookingman.model.Post

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
            viewModel.adapter.setCallBack(object  : PostCallback{
                override fun onImageFoodClick(view: View, post: Post) {
                    findNavController().navigate(R.id.action_homeFragment_to_detailCookFragment)
                }
            })
            viewModel.adapter.setList(list)
        })

    }

    override fun getLayoutId()= R.layout.fragment_home
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}