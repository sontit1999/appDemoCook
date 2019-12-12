package com.duongtung.cookingman.fragment.profile


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.RecipCallback
import com.duongtung.cookingman.base.BaseFragment
import com.duongtung.cookingman.databinding.FragProfileBinding
import com.duongtung.cookingman.fragment.home.ActionBarListener
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.model.Postres
import com.duongtung.cookingman.model.Recipe
import java.io.IOException

class ProfileFragment  : BaseFragment<FragProfileBinding,ProfileViewModel>(){
    private val GALLERY = 1
    var post : Postres? = null
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
        post = arguments!!.getSerializable("post") as Postres
        var iduser = post!!.userid.toString()
        viewModel.getUser(iduser).observe(this, Observer { user->
            Glide.with(this).load(user.linkavatar).into(binding.ivAvatar)
            binding.user = user
        })
       viewModel.getRecipe(iduser).observe(this, Observer { list->
           viewModel.adapter.setList(list)
           viewModel.adapter.setCallBack(object : RecipCallback{
               override fun onAuthorClick(view: View, post: Postres) {
                   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
               }

               override fun onLikeClick(view: View, post: Postres) {
                   viewModel.addFavorite(post.idphoto,context!!)
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
                val contentURI = data.data
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