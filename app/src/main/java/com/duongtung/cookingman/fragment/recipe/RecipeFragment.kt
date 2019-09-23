package com.duongtung.cookingman.fragment.recipe

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentRecipeBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.ui.chatlist.ChatlistActivity

class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel> (){
    override fun getClassViewMode() = RecipeViewModel::class.java
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun setBindingViewModel() {
        actionBarHomeOnClick!!.initFragment(this)
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        viewModel.getArrRecipe().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}