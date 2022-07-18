package com.thegar.starter.di

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ApplicationComponent {

    @get:ApplicationContext
    val context: Context

    val moshi: Moshi

    val application: Application
}
