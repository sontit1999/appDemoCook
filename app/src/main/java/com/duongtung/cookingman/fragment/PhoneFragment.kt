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

class PhoneFragment : Fragment() {

    var listitem = arrayOf("Viet Nam", "In Do Ne Xi A", "Thai Lan", "Trung Quoc", "Nhật Bản")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.frag_login_phone, container, false)
        val spinner = view.findViewById<Spinner>(R.id.spincountry)
        val txtCode = view.findViewById<TextView>(R.id.txtCode)
        val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, listitem)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        return view
    }
}