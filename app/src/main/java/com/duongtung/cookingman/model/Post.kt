package com.duongtung.cookingman.model

data class Post(var food: String, var location: String, var time: String, var arrayPeople: ArrayList<Person>) :
    Person("Sơn Tít", "")
//{
//    private var food : String = food
//    private var location : String = location
//    private var time : String = time
//    private var arrpeople : ArrayList<Person> = arrayPeople
//    fun getFood() : String{
//        return food
//    }
//    fun getLocation() : String{
//        return location
//    }
//    fun getTime() : String{
//        return time
//    }
//    fun getArrayPeople() : ArrayList<Person>{
//        return arrpeople
//    }
//}