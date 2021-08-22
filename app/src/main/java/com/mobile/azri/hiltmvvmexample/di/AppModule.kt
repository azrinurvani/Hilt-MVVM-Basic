package com.mobile.azri.hiltmvvmexample.di

import com.mobile.azri.hiltmvvmexample.network.RetroServiceInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val baseUrl = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetroInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRetroService(retrofit: Retrofit):RetroServiceInstance{
        return retrofit.create(RetroServiceInstance::class.java)
    }
}