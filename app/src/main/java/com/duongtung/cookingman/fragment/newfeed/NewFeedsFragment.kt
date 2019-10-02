package com.duongtung.cookingman.fragment.newfeed

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentNewfeedsBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.User

class NewFeedsFragment : BaseFragment<FragmentNewfeedsBinding, NewFeedsViewModel>() {
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
    override fun viewCreated() {
        viewModel.getArrPost().observe(this, Observer { list ->
            viewModel.adapter.setCallBack(object  : PostCallback {
                override fun onMoreClick(view: View, post: Post) {
                    Log.d("test","display dialog")
                }

                override fun onImageFoodClick(view: View, post: Post) {
                    findNavController().navigate(R.id.action_homeFragment_to_detailCookFragment)
                }

                override fun onAvatarClick(view: View, user: User) {
                    Log.d("user",user.profileUrl)
                    findNavController().navigate(R.id.profileFragment)
                }
            })
            viewModel.adapter.setList(list)
        })

    }

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.fabADD.setOnClickListener {
            Log.d("test","Đăng tin")
        }
    }

    override fun getClassViewMode() = NewFeedsViewModel::class.java

    override fun getLayoutId() = R.layout.fragment_newfeeds

    override fun onResume() {
        Log.d("test","on resume newfeed frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}