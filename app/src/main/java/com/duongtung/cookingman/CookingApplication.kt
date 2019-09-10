package com.duongtung.cookingman

import android.annotation.SuppressLint
import com.duongtung.cookingman.base.BaseApplication
import com.duongtung.cookingman.base.resource.BaseResource

class CookingApplication : BaseApplication() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        private lateinit var  resource: BaseResource
        fun getResource() = resource
    }

    override fun onCreate() {
        super.onCreate()
        resource = BaseResource(context = applicationContext)
    }
}