package com.duongtung.cookingman.fragment.profile

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragProfileBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import kotlinx.android.synthetic.main.frag_profile.*
import kotlinx.android.synthetic.main.frag_profile.view.*
import kotlinx.android.synthetic.main.frag_profile.view.tv_friend
import java.io.IOException

class ProfileFragment  : BaseFragment<FragProfileBinding,ProfileViewModel>(){
    private val GALLERY = 1
    private val CAMERA = 2
    override fun getClassViewMode()  = ProfileViewModel::class.java
    private var actionBarHomeOnClick: ActionBarListener? = null

    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment profile")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
        override fun setBindingViewModel() {
        binding.viewmodel = viewModel
            binding.ivAvatar.setOnClickListener{
                    choosePhotoFromGallary()
            }

    }

    override fun viewCreated() {
       viewModel.getArrRecipe().observe(this, Observer { list->
           viewModel.adapter.setList(list)
       })
    }

    override fun getLayoutId() = R.layout.frag_profile
    override fun onResume() {
        Log.d("test","on resume profile frag")
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
    }
    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, GALLERY)

    }
    override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                val contentURI = data!!.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, contentURI)
                    binding.ivAvatar.setImageBitmap(bitmap)
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        }

    }
}