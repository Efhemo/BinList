package com.efhem.binlist.core.di

import com.efhem.binlist.core.BuildConfig
import com.efhem.binlist.domain.repository.CardInfoRepository
import com.efhem.binlist.remote.ApiService
import com.efhem.binlist.remote.ApiServiceFactory
import com.efhem.binlist.remote.repository.CardInfoRepositoryImp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface RemoteModule {

    @get:[Binds Singleton]
    val CardInfoRepositoryImp.cardInfoRepository: CardInfoRepository

    companion object {

        @[Provides Singleton]
        fun provideApiService(moshi: Moshi): ApiService =
                ApiServiceFactory.createApiService(BuildConfig.DEBUG, moshi)

        @get:[Provides Singleton]
        val provideMoshi: Moshi
            get() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    }
}