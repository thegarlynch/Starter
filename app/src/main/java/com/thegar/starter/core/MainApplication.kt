package com.thegar.starter.core

import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.thegar.starter.BuildConfig
import com.thegar.starter.core.di.ApplicationComponent
import com.thegar.starter.helper.timber.TimberReleaseTree
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : MultiDexApplication() {

    init {
        mApp = EntryPoints.get(this, ApplicationComponent::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

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
