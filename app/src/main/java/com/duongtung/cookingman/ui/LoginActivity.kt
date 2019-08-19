package com.duongtung.cookingman.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.duongtung.cookingman.R
import com.duongtung.cookingman.fragment.PhoneFragment
import com.duongtung.cookingman.fragment.PreferanceFragment
import com.duongtung.cookingman.fragment.VerifyFragment
import devmike.jade.com.PageStepIndicator

class LoginActivity : AppCompatActivity() {

    lateinit var pageStepp : PageStepIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pageStepp = findViewById(R.id.page_stepper)
        val viewPage = findViewById<ViewPager>(R.id.viewPage)
        viewPage.adapter = ViewPageAdapter(supportFragmentManager)
        pageStepp.setupWithViewPager(viewPage)
    }

    class ViewPageAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
        val pageLists = arrayListOf(PhoneFragment(), VerifyFragment(), PreferanceFragment())

        override fun getItem(position: Int): Fragment {
           return pageLists.get(position)
        }

        override fun getCount(): Int {
            return pageLists.size
        }

    }
}
