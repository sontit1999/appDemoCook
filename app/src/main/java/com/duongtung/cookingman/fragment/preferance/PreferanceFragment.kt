package com.duongtung.cookingman.fragment.preferance


import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginPreferanceBinding
import com.duongtung.cookingman.fragment.phone.OnButtonClickListener
import com.duongtung.cookingman.ui.MainActivity


class PreferanceFragment : BaseFragment<FragLoginPreferanceBinding, PreferanceViewModel>(){
    override fun getClassViewMode() = PreferanceViewModel::class.java
    private var mOnButtonClickListener: OnButtonClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnButtonClickListener = context as OnButtonClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun setBindingViewModel() {

        binding.viewmodel = viewModel
//        binding.ivBtdone.setOnClickListener {
//            var intent = Intent(context,MainActivity::class.java)
//            startActivity(intent)
//        }
    }

    override fun viewCreated() {
        binding.viewmodel!!.onButtonClickListener = mOnButtonClickListener
        viewModel.getArrItemTypeFood().observe(this, Observer { list ->
            viewModel.adapter.setList(list)
        })
   }

    override fun getLayoutId() = R.layout.frag_login_preferance

}