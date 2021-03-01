package com.efhem.cache.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.efhem.cache.BuildConfig
import com.efhem.cache.entity.CardInfoCache

@Database(
    entities = [CardInfoCache::class],
    version = BuildConfig.databaseVersion,
    exportSchema = false
)
abstract class BinListDatabase : RoomDatabase() {

    abstract val cardInfoDao: CardInfoDao

    companion object {
        private const val DATABASE_NAME: String = "bin_list_db"
        fun build(context: Context): BinListDatabase = Room.databaseBuilder(
            context.applicationContext,
            BinListDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}
