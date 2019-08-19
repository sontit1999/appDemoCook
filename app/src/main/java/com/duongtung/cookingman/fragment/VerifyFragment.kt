package com.duongtung.cookingman.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duongtung.cookingman.R

class VerifyFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment {
            return VerifyFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.frag_login_verify, container, false)
        return view
    }
}