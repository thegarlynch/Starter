package com.thegar.starter.di

import com.squareup.moshi.Moshi
import com.thegar.compat.CrossVariant
import com.thegar.compat.provideReflectionFactory
import com.thegar.starter.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

    @Provides
    @Singleton
    fun okHttpBuilder(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addNetworkInterceptor(loggingInterceptor)
        }
        return builder.build()
    }
}
