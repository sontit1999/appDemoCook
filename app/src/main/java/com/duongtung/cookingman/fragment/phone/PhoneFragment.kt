package com.duongtung.cookingman.fragment.phone

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.TextView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.customview.CustomEditText
import com.duongtung.cookingman.databinding.FragLoginPhoneBinding


class PhoneFragment : BaseFragment<FragLoginPhoneBinding, PhoneViewModel>() {

    override fun getClassViewMode() = PhoneViewModel::class.java
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
    }
    override fun getLayoutId() = R.layout.frag_login_phone

    override fun viewCreated() {
        val listItem: ArrayList<String> = arrayListOf("Viet Nam", "In Do Ne Xi A", "Thai Lan", "Trung Quoc", "Nhật Bản")
        val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, listItem)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spincountry.adapter = adapter
        binding.viewmodel!!.onButtonClickListener = mOnButtonClickListener
        binding.edtPhone.onError(object: CustomEditText.OnErrorListener{
            override fun onErrorListener(boolean: Boolean) {
                binding.viewmodel!!.isError = boolean
            }
        })
    }

}