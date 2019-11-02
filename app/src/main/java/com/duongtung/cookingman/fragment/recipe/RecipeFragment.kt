package com.duongtung.cookingman.fragment.recipe

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.callback.RecipeAPIs
import com.duongtung.cookingman.databinding.FragmentRecipeBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Recipe
import com.duongtung.cookingman.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
//        viewModel.getArrRecipe().observe(this, Observer { list ->
//            viewModel.adapter.setList(list)
//            viewModel.adapter.setCallBack(object : PostCallback{
//                override fun onImageFoodClick(view: View, post: Post) {
//                    findNavController().navigate(R.id.detailCookFragment)
//                }
//
//                override fun onAvatarClick(view: View, user: User) {
//
//                }
//
//                override fun onMoreClick(view: View, post: Post) {
//                        Log.d("test","đã lưu food")
//                }
//            })
//        })
        viewModel.getRecipe().observe(this, Observer { list->
            viewModel.adapter.setList(list)
        })
    }

    override fun getLayoutId() = R.layout.fragment_recipe
    override fun onResume() {
        Log.d("test","on resume recipe frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}