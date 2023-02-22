package com.example.network.di.networkmodule

import com.example.network.APICallService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {
    @Singleton
    @Provides
    fun provideAPICallService(retrofit: Retrofit): APICallService {
        return  retrofit.create(APICallService::class.java)
    }
}