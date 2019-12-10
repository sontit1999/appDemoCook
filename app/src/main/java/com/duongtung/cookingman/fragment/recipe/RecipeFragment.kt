package com.duongtung.cookingman.fragment.recipe

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipCallback
import com.duongtung.cookingman.adapter.RecipeCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentRecipeBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe


class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel> (){
    override fun getClassViewMode() = RecipeViewModel::class.java
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment recipe")
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
        binding.fabADD.setOnClickListener {
            Log.d("test","chuyển đến màn đăng món ăn")
        }



    }

    override fun viewCreated() {
        viewModel.getpost().observe(this, Observer { list->
            viewModel.adapter.setList(list)
            binding.pgLoading.visibility = View.GONE
            viewModel.adapter.setCallBack(object : RecipCallback{
                override fun onAuthorClick(view: View, recipe: Recipe) {

                }

                override fun onLikeClick(view: View, recipe: Recipe) {

                }

                override fun onRecipeClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    // CurentUser.post = post
                    findNavController().navigate(R.id.detailCookFragment,bundle)
                }

            })
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe
    override fun onResume() {
        Log.d("test","on resume recipe frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}