package com.duongtung.cookingman.ui.postnew

import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.Settings
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.base.BaseActivity
import com.duongtung.cookingman.customview.CustomEditText
import com.duongtung.cookingman.databinding.ActivityPostNewfeedBinding
import com.duongtung.cookingman.model.APIClient
import com.duongtung.cookingman.model.CurentUser
import com.duongtung.cookingman.service.DemoApi
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.net.URI


class PostNewActivity : BaseActivity<ActivityPostNewfeedBinding,PostNewViewmodel>() {
    private val GALLERY = 1
    private val RECORD_REQUEST_CODE = 101
    var imageString : String = ""
    override fun getViewMode() = PostNewViewmodel::class.java

    override fun getLayout() = R.layout.activity_post_newfeed

    override fun setBindingViewModel() {
        setupPermissions()
      //  prepareView()
        binding.viewmodel = viewModel


        setupSpinner()

        binding.tvReturn.setOnClickListener { finish() }

        binding.tvPost.setOnClickListener {
            addPost()
        }
        binding.tvAddStep.setOnClickListener { Add_Line() }

        binding.ivFood.setOnClickListener {
            choosePhotoFromGallary()
        }

        viewModel.getStatus().observe(this, Observer { status->
            if(status.equals("succes")){
                finish()
            }else if(status.equals("fail")){
                binding.pbLoadding.visibility = View.INVISIBLE
                Toast.makeText(this,"Lỗi chưa đăng dc.",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setupSpinner() {
        val listItem: ArrayList<String> = arrayListOf("Nước uống", "Món chính", "Món tráng miệng")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItem)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spincountry.adapter = adapter
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

    fun addPost(){
        var make: String = ""
        var caption: String = binding.edtCaption.text.toString()
        var namerecipe: String = binding.edtNamerecipe.text.toString()
        var timecomplete: String = binding.edtTimecomplete.text.toString()
        var ingredient: String = binding.edtIngre.text.toString()
        var menuid: String = "0"
        val count: Int = binding.contaimerMake.getChildCount()-1

        // get how to make
        for (i in 1..count) {
            val view: View = binding.contaimerMake.getChildAt(i)

            if(view is EditText){
                val edt = view as EditText
                if(!edt.text.toString().equals("")) {
                    make = make.plus(edt.text.toString()).plus("\n")
                }
            }
        }

        // get type food
        when(binding.spincountry.selectedItem.toString()){
            "Món tráng miệng" -> menuid = "2"
            "Món chính" -> menuid = "4"
            "Nước uống" -> menuid = "1"
        }
       // check empty
        if(namerecipe.equals("") || caption.equals("") || timecomplete.equals("") || ingredient.equals("") || make.equals("") || menuid.equals("")){
            Toast.makeText(this,"ko dc bỏ trống trường nào",Toast.LENGTH_LONG).show()
        }else if(imageString==""){
            Toast.makeText(this,"Chưa chọn ảnh",Toast.LENGTH_LONG).show()
        }else{
            binding.pbLoadding.visibility = View.VISIBLE
            viewModel.addPost(namerecipe,caption,imageString,ingredient,make,CurentUser.user.id,menuid,timecomplete,baseContext)
        }
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

//                Log.d("data",data.data.toString())
//                Log.d("data",getRealPathFromURI(data.data!!))
                  imageString = getRealPathFromURI(data.data!!)
                  uploadFile(imageString)
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, contentURI)
                    binding.ivFood.setImageBitmap(bitmap)
                    imageString = getBase64String(bitmap)
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
    fun uploadFile(filepath:String){
        var file = File(filepath)
        var filePart:MultipartBody.Part = MultipartBody.Part.createFormData("file",
            file.name, RequestBody.create(MediaType.parse("image/*"), file))
        val retrofit = APIClient.getClient()
        val callapi = retrofit.create(DemoApi::class.java)
        val call = callapi.uploadAttachment(filePart)
        call.enqueue(object : Callback<com.duongtung.cookingman.model.Response>{
            override fun onFailure(
                call: Call<com.duongtung.cookingman.model.Response>,
                t: Throwable
            ) {
                Log.d("ahihi","ko thành công do " + t.message.toString())
            }

            override fun onResponse(
                call: Call<com.duongtung.cookingman.model.Response>,
                response: Response<com.duongtung.cookingman.model.Response>
            ) {
                Log.d("ahihi","thành công:" + response.body()!!.link)
            }
        })
    }

     fun getRealPathFromURI(contentURI:Uri) : String {
        var filePath:String = ""
        var cursor = contentResolver.query(contentURI, null, null, null, null);
        if (cursor == null) {
            filePath = contentURI.path.toString()
        } else {
            cursor.moveToFirst()
            var idx : Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            filePath = cursor.getString(idx)
            cursor.close()
        }
        return filePath
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            READ_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"chưa cấp quyền",Toast.LENGTH_LONG).show()
            makeRequest()
        }else{
            Toast.makeText(this,"Đã cấp quyền",Toast.LENGTH_LONG).show()
        }
    }
    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(READ_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i("ahihi", "Permission has been denied by user")
                } else {
                    Log.i("ahihi", "Permission has been granted by user")
                }
            }
        }
    }
}
