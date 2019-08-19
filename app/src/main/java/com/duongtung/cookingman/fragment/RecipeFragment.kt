package com.duongtung.cookingman.fragment

import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipeAdapter
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentRecipeBinding

class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel> (){
    override fun getClassViewMode() = RecipeViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }

    override fun viewCreated() {
        viewModel.getArrRecipe().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe
}