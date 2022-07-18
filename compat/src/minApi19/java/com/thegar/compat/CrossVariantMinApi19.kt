package com.thegar.compat

import android.app.Application
import androidx.multidex.MultiDex

fun CrossVariant.attachBaseContext(application: Application) {
    MultiDex.install(application)
}