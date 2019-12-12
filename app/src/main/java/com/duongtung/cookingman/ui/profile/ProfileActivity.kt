package com.duongtung.cookingman.ui.profile

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.ActivityProfileBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe

class ProfileActivity : BaseFragment<ActivityProfileBinding,ProfileActivityViewmodel>() {
    private var actionBarHomeOnClick: ActionBarListener? = null
    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment newfeed")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = ProfileActivityViewmodel::class.java

    override fun viewCreated() {
        viewModel.getRecipe(CurentUser.user.id).observe(this, Observer { list->
            viewModel.adapter.setList(list)
            viewModel.adapter.setCallBack(object : RecipCallback {
                override fun onAuthorClick(view: View, postres: Postres) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onLikeClick(view: View, postres: Postres) {
                    viewModel.addFavorite(postres.idphoto,context!!)
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

    override fun getLayoutId() = R.layout.activity_profile
    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.user = CurentUser.user
    }

    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}