package com.duongtung.cookingman.fragment.recipe

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentRecipeBinding
import com.duongtung.cookingman.ui.chatlist.ChatlistActivity

class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel> (){
    override fun getClassViewMode() = RecipeViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recyclerviewRecipe.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        binding.fabADD.setOnClickListener {
            startActivity(Intent(context,ChatlistActivity::class.java))
        }
    }

    override fun viewCreated() {
        viewModel.getArrRecipe().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }
}