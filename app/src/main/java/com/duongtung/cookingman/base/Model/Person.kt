package com.duongtung.cookingman.base.Model

open class Person(name: String, avatar: String){
    private var name : String = name
    private var avatar : String = avatar
    fun setName(name: String){
       this.name = name
    }
    fun getName() : String {
        return name
    }
    fun setAvater(avatar: String){
        this.avatar = avatar
    }
    fun getAvatar() : String {
        return avatar
    }
}