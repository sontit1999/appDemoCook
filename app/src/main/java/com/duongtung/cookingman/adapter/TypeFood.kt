package com.duongtung.cookingman.adapter

class TypeFood (Image: Int, Title: String, Describe: String) {

    private var Image : Int = Image
    private var Title : String = Title
    private var Describe : String = Describe

    fun getImage() : Int {
        return Image
    }

    fun setImage(img : Int) {
        Image = img
    }

    fun getTitle() : String {
        return Title
    }

    fun setTitle(title: String) {
        Title = title
    }

    fun getDescribe() : String {
        return Describe
    }

    fun setDescribe(describe : String ) {
        Describe = describe
    }
}