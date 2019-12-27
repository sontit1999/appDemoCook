package com.duongtung.cookingman.ui.register

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Base64
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.databinding.ActivityRegisterBinding
import java.io.ByteArrayOutputStream
import java.io.IOException

class RegisterAcitvity  : BaseActivity<ActivityRegisterBinding,RegisterViewModel>(){
    var imagestringAvatar: String = ""
    private val GALLERY = 1
    override fun getViewMode() = RegisterViewModel::class.java

    override fun getLayout() = R.layout.activity_register

    override fun setBindingViewModel() {
       binding.viewModel = viewModel

        binding.ivAvatar.setOnClickListener {
            choosePhotoFromGallary()
        }
       binding.btnRegister.setOnClickListener {
           var email : String = binding.etGmail.text.toString()
           var pass : String = binding.etPass.text.toString()
           var nickname : String = binding.etNickname.text.toString()
           var describe : String = binding.etMota.text.toString()
           var avatar : String = imagestringAvatar
           if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) ||  TextUtils.isEmpty(nickname) ||  TextUtils.isEmpty(describe)){
               Toast.makeText(this,"Not empty",Toast.LENGTH_LONG).show()
           }else if(imagestringAvatar==""){
               Toast.makeText(this,"you not choose avatar! ",Toast.LENGTH_LONG).show()
           }else{
               binding.pbLoadding.visibility = View.VISIBLE
               viewModel.register(email,pass,nickname,describe,avatar)
           }
       }
        viewModel.getsStatus().observe(this, Observer { status->
            if(status.equals("succes")){
                finish()
                Toast.makeText(this,"Register succes",Toast.LENGTH_LONG).show()
            }else if(status.equals("fail")){
                Toast.makeText(this,"Register fail",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun getToolbar() = null
    private fun getBase64String(bitmap: Bitmap): String{
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes = baos.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.NO_WRAP)
    }
    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, GALLERY)

    }
    override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                val contentURI = data.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, contentURI)
                    binding.ivAvatar.setImageBitmap(bitmap)
                    imagestringAvatar = getBase64String(bitmap)
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        }

    }
}