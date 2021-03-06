package com.duongtung.cookingman.fragment.recipe

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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
import com.duongtung.cookingman.ui.postnew.PostNewActivity


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
            activity!!.startActivity(Intent(context,PostNewActivity::class.java))
        }



    }

    override fun viewCreated() {
        viewModel.getpost().observe(this, Observer { list->
            viewModel.adapter.setList(list.shuffled().take(20) as MutableList<Postres>)
            binding.pgLoading.visibility = View.GONE
            viewModel.adapter.setCallBack(object : RecipCallback{
                override fun onAuthorClick(view: View,post: Postres ) {

                }

                override fun onLikeClick(view: View, post: Postres) {
                         viewModel.addFavorite(post.idphoto,context!!)
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