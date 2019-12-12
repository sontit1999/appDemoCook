package com.duongtung.cookingman.fragment.resultsearch

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragResultSearchBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Post
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.User

class ResultSearchFragment : BaseFragment<FragResultSearchBinding,ResultSearchViewModel>(){
    var keyword = ""
    private var actionBarHomeOnClick: ActionBarListener? = null


    override fun getClassViewMode() = ResultSearchViewModel::class.java

    override fun onAttach(context: Context) {
        keyword = arguments!!.getString("keyword").toString()
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
            viewModel.adapter.setCallback(object : PostCallback{
                override fun onImageFoodClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    // CurentUser.post = post
                    findNavController().navigate(R.id.detailCookFragment,bundle)
                }

                override fun onAvatarClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    findNavController().navigate(R.id.profileFragment,bundle)
                }

                override fun onMoreClick(view: View, post: Postres) {
                   viewModel.addFavorite(post.idphoto,context!!)
                }
            })
        })
       // Toast.makeText(context,"Nhận dc " + keyword, Toast.LENGTH_LONG).show()
        viewModel.search(keyword)
    }

    override fun getLayoutId()= R.layout.frag_result_search
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}