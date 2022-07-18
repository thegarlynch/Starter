package com.thegar.starter.di

import com.squareup.moshi.Moshi
import com.thegar.compat.CrossVariant
import com.thegar.compat.provideReflectionFactory
import com.thegar.starter.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun moshi(): Moshi {
        val builder = Moshi.Builder()
        if (BuildConfig.DEBUG) {
            builder.add(CrossVariant.provideReflectionFactory())
        }
        return builder.build()
    }

}