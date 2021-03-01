package com.efhem.cache.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.cache.entity.CardInfoCache
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardInfo(cardInfoCache: CardInfoCache)

    @Query("SELECT * FROM CARD_INFO")
    fun searches(): Flow<List<CardInfoCache>>

    @Query("DELETE FROM CARD_INFO")
    fun clearHistory()
}