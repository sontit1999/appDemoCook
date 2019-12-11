package com.duongtung.cookingman.fragment.detailcook

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragmentDetailCookBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres


class DetailCookFragment : BaseFragment<FragmentDetailCookBinding, DetailCookViewModel>() {
    var post : Postres? = null
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        post = arguments!!.getSerializable("post") as Postres
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
            var content = binding.edtCommnet.text.toString()
            if(content.equals("")){
                Toast.makeText(context,"Comment not empty!", Toast.LENGTH_LONG).show()
            }else{
                viewModel.addComment(content,post!!.idphoto,CurentUser.user.id)
                binding.edtCommnet.setText("")
                binding.edtCommnet.hideKeyboard()
                binding.nestedScroll.fullScroll(View.FOCUS_UP)
                binding.nestedScroll.smoothScrollTo(0,0)
            }

        }
    }

    override fun viewCreated() {
        binding.post = post
        val idpost = post!!.idphoto
        viewModel.getArrComment(idpost).observe(this, Observer { list->
            viewModel.adapterComment.setList(list)
        })
    }

    override fun getLayoutId()= R.layout.fragment_detail_cook
    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
