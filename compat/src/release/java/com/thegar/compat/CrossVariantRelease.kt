package com.thegar.compat

import com.squareup.moshi.JsonAdapter

fun CrossVariant.provideReflectionFactory(): JsonAdapter.Factory {
    throw UnsupportedOperationException("Should not used reflection for release build")
}