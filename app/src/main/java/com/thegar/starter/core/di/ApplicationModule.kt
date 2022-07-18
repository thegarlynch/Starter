package com.thegar.starter.core.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.thegar.compat.CrossVariant
import com.thegar.compat.provideReflectionFactory
import com.thegar.starter.BuildConfig
import com.thegar.starter.core.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun okHttpBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addNetworkInterceptor(loggingInterceptor)
        }
        return builder
    }

    @Provides
    @Singleton
    fun okHttpClient(okHttpBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun databaseBuilder(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "thegar")
            .build()
    }
}
