package com.duongtung.cookingman.fragment.phone

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.TextView
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
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
        binding.edtPhone.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(editable: Editable?) {
                if(editable!!.length in 10..10){
                    if(editable.matches(regex = Regex.fromLiteral("^+?(?:[0-9]??).{5,14}[0-9]\$"))){
                        binding.edtPhone.error = context!!.resources.getString(R.string.validate_phone_wrong_number)
                    }
                }else if (editable.length<10 || editable.length>10){
                    binding.edtPhone.error = context!!.resources.getString(R.string.validate_phone_missing_number)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

}