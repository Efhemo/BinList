package com.efhem.cache.di

import android.content.Context
import com.efhem.cache.room.BinListDatabase
import com.efhem.cache.room.CardInfoDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface CacheModule {


    companion object {
        @[Provides Singleton]
        fun provideDatabase(@ApplicationContext context: Context): BinListDatabase {
            return BinListDatabase.build(context)
        }

        @[Provides Singleton]
        fun provideCardInfoDao(binListDatabase: BinListDatabase): CardInfoDao {
            return binListDatabase.cardInfoDao
        }
    }
}
