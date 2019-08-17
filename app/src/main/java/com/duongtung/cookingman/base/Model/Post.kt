package com.duongtung.cookingman.base.Model

class Post(food: String,location: String,time: String,arrayPeople: ArrayList<Person>) : Person("Sơn Tít","")
{
    private var food : String = food
    private var location : String = location
    private var time : String = time
    private var arrpeople : ArrayList<Person> = arrayPeople
    fun getFood() : String{
        return food
    }
    fun getLocation() : String{
        return location
    }
    fun getTime() : String{
        return time
    }
    fun getArrayPeople() : ArrayList<Person>{
        return arrpeople
    }
}