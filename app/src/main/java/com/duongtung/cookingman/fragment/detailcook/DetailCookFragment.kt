package com.duongtung.cookingman.fragment.detailcook

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentDetailCookBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.Comment
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.User


class DetailCookFragment : BaseFragment<FragmentDetailCookBinding, DetailCookViewModel>() {
    var post : Postres? = null
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }

    override fun getClassViewMode() = DetailCookViewModel::class.java

    override fun setBindingViewModel() {
        binding.viewModel = viewModel
        binding.tvSend.setOnClickListener {
            val comment = binding.edtCommnet.text!!.trim().toString()
            if(comment.equals("")){
                makeText(activity,"Comment not empty",Toast.LENGTH_LONG).show()
            }else{
                viewModel.addComment((Comment(1, User(1,"Sơn tít","http://media2.sieuhai.tv:8088/onbox/images/user_lead_image/20190408/84947430634_20190408001343.jpg"),comment,"4")))
                binding.edtCommnet.setText("")
            }
        }

    }

    override fun viewCreated() {
        post = arguments!!.getSerializable("post") as Postres
        binding.post = post
        viewModel.getArrComment().observe(this, Observer { list->
            viewModel.adapterComment.setList(list)
        })
        viewModel.getArrIngredient().observe(this, Observer { list->
            viewModel.adapterIngredient.setList(list)
        })
        viewModel.getArrDirection().observe(this, Observer { list->
            viewModel.adapterDirection.setList(list)
        })
    }

    override fun getLayoutId()=R.layout.fragment_detail_cook
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
}
