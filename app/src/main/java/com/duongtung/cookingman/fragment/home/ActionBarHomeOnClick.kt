package com.duongtung.cookingman.fragment.home

import androidx.fragment.app.Fragment
import com.duongtung.cookingman.model.Postres

interface ActionBarListener {
    fun initFragment(fragment: Fragment)
    fun onResumeFragment(fragment: Fragment)
}