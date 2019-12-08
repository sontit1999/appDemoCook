package com.duongtung.cookingman.fragment.resultsearch

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragResultSearchBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

class ResultSearchFragment : BaseFragment<FragResultSearchBinding,ResultSearchViewModel>(){
    private var actionBarHomeOnClick: ActionBarListener? = null


    override fun getClassViewMode() = ResultSearchViewModel::class.java

    override fun onAttach(context: Context) {

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
        viewModel.getArrPost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId()= R.layout.frag_result_search
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}