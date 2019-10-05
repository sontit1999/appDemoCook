package com.duongtung.cookingman.fragment.favorite

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragFavoriteBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User
import java.util.*

class FavoriteFragment : BaseFragment<FragFavoriteBinding,FavoriteViewModel>(){
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

    override fun getClassViewMode() = FavoriteViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.recipeFavorite.layoutManager = GridLayoutManager(context,2)
    }

    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
            viewModel.adapter.setCallBack(object  : PostCallback{
                override fun onImageFoodClick(view: View, post: Post) {
                       findNavController().navigate(R.id.detailCookFragment)
                }

                override fun onAvatarClick(view: View, user: User) {
                    findNavController().navigate(R.id.profileFragment)
                }

                override fun onMoreClick(view: View, post: Post) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        })
    }

    override fun getLayoutId() = R.layout.frag_favorite
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}