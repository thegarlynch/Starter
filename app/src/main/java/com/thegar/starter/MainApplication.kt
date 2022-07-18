package com.thegar.starter

import android.app.Application
import android.content.Context
import com.thegar.compat.CrossVariant
import com.thegar.compat.attachBaseContext
import com.thegar.starter.di.ApplicationComponent
import com.thegar.starter.helper.TimberReleaseTree
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    init {
        mApp = EntryPoints.get(this, ApplicationComponent::class.java)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        CrossVariant.attachBaseContext(this)
    }

    override fun onCreate() {
        super.onCreate()
        val tree = if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            TimberReleaseTree()
        }

        Timber.plant(tree)
    }
}

private var mApp: ApplicationComponent? = null
val App: ApplicationComponent get() = mApp ?: throw AssertionError("App is not initialized")
