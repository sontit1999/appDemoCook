package com.duongtung.cookingman.base.repository.listener

interface IServiceRespond <T> {
    fun onSuccess(result : T)
    fun onError(message: String)
}
