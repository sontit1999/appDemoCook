package com.duongtung.cookingman.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding,ProfileViewModel>(){
    override fun getViewMode() = ProfileViewModel::class.java

    override fun getLayout() = R.layout.activity_profile

    override fun setBindingViewModel() {
       binding.viewmodel = viewModel
    }

}
