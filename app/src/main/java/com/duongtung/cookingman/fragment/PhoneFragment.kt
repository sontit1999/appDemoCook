package com.duongtung.cookingman.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragLoginPhoneBinding

class PhoneFragment : BaseFragment<FragLoginPhoneBinding,PhoneViewModel>() {
    override fun getClassViewMode() = PhoneViewModel::class.java


    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
    }
    override fun getLayoutId() = R.layout.frag_login_phone

    override fun viewCreated() {
        var listitem: ArrayList<String> = arrayListOf("Viet Nam", "In Do Ne Xi A", "Thai Lan", "Trung Quoc", "Nhật Bản")
        val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, listitem)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spincountry.adapter = adapter
    }



}