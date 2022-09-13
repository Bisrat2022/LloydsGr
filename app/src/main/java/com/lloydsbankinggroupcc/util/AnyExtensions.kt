package com.lloydsbankinggroupcc.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.lloydsbankinggroupcc.ui.PetsApplication
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody

fun petAppContext(): Context = PetsApplication.getAppContext().applicationContext

fun sharedPref(): SharedPref = SharedPref()

inline fun <reified T : Any> cast(any: Any?): T? = T::class.javaObjectType.cast(any)

inline fun <reified T : Any> convertBody(responseBody: ResponseBody?): T? {
    return try {
        responseBody?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(T::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}

fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}