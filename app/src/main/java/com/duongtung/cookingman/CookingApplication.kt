package com.duongtung.cookingman

import android.annotation.SuppressLint
import com.duongtung.cookingman.base.BaseApplication
import com.duongtung.cookingman.base.repository.BaseRepository
import com.duongtung.cookingman.base.resource.BaseResource
import com.duongtung.cookingman.service.RecipeAPIs

class CookingApplication : BaseApplication() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        private lateinit var  resource: BaseResource
        fun getResource() = resource
        lateinit var serviceApi: RecipeAPIs
    }

    override fun onCreate() {
        super.onCreate()
        resource = BaseResource(context = applicationContext)
        serviceApi = BaseRepository.instance.getContext(this)!!
            .setBaseUrl("http://sonhaui.000webhostapp.com/")!!
            .createService(RecipeAPIs::class.java)
    }
}