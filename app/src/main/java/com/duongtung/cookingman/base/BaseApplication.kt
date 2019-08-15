package com.duongtung.cookingman.base

import android.app.Application
import com.duongtung.cookingman.base.resource.BaseResource

abstract class BaseApplication : Application() {

    private lateinit var  resource: BaseResource

    open fun getResource() = resource

    override fun onCreate() {
        super.onCreate()
        resource = BaseResource(context = applicationContext)
    }
}
