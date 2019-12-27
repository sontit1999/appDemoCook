package com.duongtung.cookingman.ui.profile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.ActivityProfileBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe
import com.duongtung.cookingman.ui.postnew.PostNewActivity
import java.io.ByteArrayOutputStream
import java.io.IOException

class ProfileActivity : BaseFragment<ActivityProfileBinding,ProfileActivityViewmodel>() {
    private val GALLERY = 1
    var imageString : String = ""
    var typeupdate:String = "avatar"
    private var actionBarHomeOnClick: ActionBarListener? = null
    override fun onAttach(context: Context) {
        Log.d("test","on attack fragment newfeed")
        super.onAttach(context)
        try {
            actionBarHomeOnClick = context as ActionBarListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement OnButtonClickListener")
        }
    }
    override fun getClassViewMode() = ProfileActivityViewmodel::class.java

    override fun viewCreated() {
        viewModel.getRecipe(CurentUser.user.id).observe(this, Observer { list->
            viewModel.adapter.setList(list)
            viewModel.adapter.setCallBack(object : RecipCallback {
                override fun onAuthorClick(view: View, postres: Postres) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onLikeClick(view: View, postres: Postres) {
                    viewModel.addFavorite(postres.idphoto,context!!)
                }

                override fun onRecipeClick(view: View, post: Postres) {
                    val bundle = Bundle()
                    bundle.putSerializable("post", post)
                    // CurentUser.post = post
                    findNavController().navigate(R.id.detailCookFragment,bundle)
                }
            })
        })
    }

    override fun getLayoutId() = R.layout.activity_profile
    override fun setBindingViewModel() {
        binding.viewmodel = viewModel
        binding.user = CurentUser.user
        Glide.with(this).load("https://aphoto.vn/wp-content/uploads/2017/07/%E1%BA%A3nh-thi%C3%AAn-nhi%C3%AAn-%C4%91%E1%BA%B9p.jpg").into(binding.headerCoverImage)
        binding.fabADD.setOnClickListener { startActivity(
            Intent(context,
                PostNewActivity::class.java)
        ) }
        binding.ivAvatar.setOnClickListener{
            typeupdate = "avatar"
            choosePhotoFromGallary()

        }
    }

    override fun onResume() {
        super.onResume()
        actionBarHomeOnClick!!.onResumeFragment(this)
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
                    if(typeupdate.equals("avatar")){
                        binding.ivAvatar.setImageURI(contentURI)
                    }
                    var bitmap = (binding.ivAvatar.drawable as BitmapDrawable).bitmap
                    imageString = getBase64String(bitmap)
                    viewModel.updateProfile(typeupdate,imageString,context!!)
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        }

    }

    private fun getBase64String(bitmap: Bitmap): String{
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes = baos.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.NO_WRAP)
    }
}