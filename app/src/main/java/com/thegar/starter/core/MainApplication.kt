package com.thegar.starter.core

import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.thegar.starter.core.di.ApplicationComponent
import com.thegar.starter.helper.Install
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : MultiDexApplication() {

    init {
        mApp = EntryPoints.get(this, ApplicationComponent::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

        Install.timber()
        Install.security()
    }
}

private var mApp: ApplicationComponent? = null
val App: ApplicationComponent get() = mApp ?: throw AssertionError("App is not initialized")
