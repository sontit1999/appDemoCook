package com.duongtung.cookingman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.base.Model.Person
import com.duongtung.cookingman.base.Model.Post
import com.duongtung.cookingman.base.fragment.BangtinFragment
import kotlinx.android.synthetic.main.custom_actionbar.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(BangtinFragment())
    }
    fun loadFragment(fragment : Fragment){
        var fragmentmanager : FragmentManager = supportFragmentManager
        var transition : FragmentTransaction = fragmentmanager.beginTransaction()
        transition.replace(R.id.containerBangtin,fragment)
        transition.commit()
    }
}
