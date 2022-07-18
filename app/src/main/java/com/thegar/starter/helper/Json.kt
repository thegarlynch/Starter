package com.thegar.starter.helper

import com.squareup.moshi.adapter
import com.thegar.starter.App

@OptIn(ExperimentalStdlibApi::class)
object Json {

    inline fun <reified T> encode(value: T): String {
        val adapter = App.moshi.adapter<T>()
        return adapter.toJson(value)
    }

    inline fun <reified T> decode(text: String): T? {
        val adapter = App.moshi.adapter<T>()
        return adapter.fromJson(text)
    }
}
