package com.thegar.compat

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun CrossVariant.provideReflectionFactory(): JsonAdapter.Factory {
    return KotlinJsonAdapterFactory()
}