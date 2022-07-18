package com.thegar.starter

import android.app.Application
import android.content.Context
import com.thegar.compat.CrossVariant
import com.thegar.compat.attachBaseContext
import com.thegar.starter.di.ApplicationComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    init {
        mApp = EntryPoints.get(this, ApplicationComponent::class.java)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CrossVariant.attachBaseContext(this)
    }
}

private var mApp: ApplicationComponent? = null
val App: ApplicationComponent get() = mApp ?: throw AssertionError("App is not initialized")
