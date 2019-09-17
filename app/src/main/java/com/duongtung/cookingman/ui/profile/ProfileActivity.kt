package com.duongtung.cookingman.ui.profile
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipeCallback
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityProfileBinding
import com.duongtung.cookingman.ui.chatdetail.DetailChatActivity
import com.duongtung.cookingman.ui.setting.SettingActivity

class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>() {
        override fun getViewMode() = ProfileViewModel::class.java

        override fun getLayout() = R.layout.activity_profile

        override fun setBindingViewModel() {

            var intent = intent
            if (intent != null) {
                Log.d("test", "cos data")
                Log.d("test", intent.getStringExtra("iduser"))
            } else Log.d("test", "ko co data")
            binding.viewmodel = viewModel

            binding.tvReturn.setOnClickListener {
                finish()
            }
            binding.tvNameAuthor.setOnClickListener {  }
            binding.tvFollow.setOnClickListener {
                goToActivity(SettingActivity::class.java,null,null)
                Toast.makeText(baseContext, "Đã follow!", Toast.LENGTH_SHORT).show() }
            binding.tvMesage.setOnClickListener {
                goToActivity(DetailChatActivity::class.java, null, null)
            }
            viewModel.getArrRecipe().observe(this, Observer { list ->
                viewModel.adapter.setList(list)
            })

        }

    }

