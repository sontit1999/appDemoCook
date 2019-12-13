package com.duongtung.cookingman.ui.postnew

import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.customview.CustomEditText
import com.duongtung.cookingman.databinding.ActivityPostNewfeedBinding
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres


class PostNewActivity : BaseActivity<ActivityPostNewfeedBinding,PostNewViewmodel>() {
    override fun getViewMode() = PostNewViewmodel::class.java

    override fun getLayout() = R.layout.activity_post_newfeed

    override fun setBindingViewModel() {
        prepareView()
        binding.viewmodel = viewModel
        val listItem: ArrayList<String> = arrayListOf("Nước uống", "Món chính", "Món tráng miệng")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItem)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spincountry.adapter = adapter

        binding.tvReturn.setOnClickListener { finish() }

        binding.tvPost.setOnClickListener {
            Toast.makeText(this,"đăng",Toast.LENGTH_LONG).show()
            addPost()
        }
        binding.tvAddStep.setOnClickListener { Add_Line() }


        viewModel.getStatus().observe(this, Observer { status->
            finish()
        })
    }

    override fun getToolbar(): Toolbar? {
       return null
    }

    fun Add_Line() {
        // add edittext
        val editText = CustomEditText(this)
        editText.setHint("bước " + binding.contaimerMake.childCount + ":")
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 30, 0, 0)
        editText.setLayoutParams(layoutParams)
        binding.contaimerMake.addView(editText)
    }
    fun prepareView(){
        // add edittext
        val editText = CustomEditText(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, 0)
        editText.setLayoutParams(layoutParams)
        binding.containerCaption.addView(editText)
        Add_Line()
    }
    fun addPost(){
        var make: String = ""
        var caption: String = ""
        var namerecipe: String = binding.edtNamerecipe.text.toString()
        var linkimage: String = "link image"
        var timecomplete: String = binding.edtTimecomplete.text.toString()
        var ingredient: String = binding.edtIngre.text.toString()
        var menuid: String = "0"
        val count: Int = binding.contaimerMake.getChildCount()-1
        for (i in 1..count) {
            val view: View = binding.contaimerMake.getChildAt(i)

            if(view is EditText){
                val edt = view as EditText
                if(!edt.text.toString().equals("")) {
                    make = make.plus(edt.text.toString()).plus("\n")
                }
            }
        }

        for (i in 1..binding.containerCaption.childCount-1) {
            val view: View = binding.containerCaption.getChildAt(i)
            if(view is EditText){
                val edt = view as EditText
                caption = caption.plus(edt.text.toString())
            }
        }
        when(binding.spincountry.selectedItem.toString()){
            "Món tráng miệng" -> menuid = "2"
            "Món chính" -> menuid = "4"
            "Nước uống" -> menuid = "1"
        }

        if(namerecipe.equals("") || caption.equals("") || linkimage.equals("") || timecomplete.equals("") || ingredient.equals("") || make.equals("") || menuid.equals("")){
            Toast.makeText(this,"ko dc bỏ trống trường nào",Toast.LENGTH_LONG).show()
        }else{
            viewModel.addPost(namerecipe,caption,"image",ingredient,make,CurentUser.user.id,menuid,timecomplete,baseContext)
        }
    }
}