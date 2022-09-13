package com.lloydsbankinggroupcc.util

sealed class ResponseWrapper<T>(
    val data: T? = null, val msg: String? = null,
    val code: Int? = null
) {

    class Success<T>(data: T) : ResponseWrapper<T>(data = data)

    class Failure<T>(msg: String?, code: Int? = null, data: T? = null) :
        ResponseWrapper<T>(msg = msg)

    class Loading<T> : ResponseWrapper<T>()

}
