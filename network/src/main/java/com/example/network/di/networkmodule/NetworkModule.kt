package com.example.network.di.networkmodule

import com.example.network.constants.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //getting instance of OKHttpClient
    @Provides
    fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    //getting instance of Retrofit
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(NetworkConstants.sBaseUrl).client(getClient()).build()
    }

}