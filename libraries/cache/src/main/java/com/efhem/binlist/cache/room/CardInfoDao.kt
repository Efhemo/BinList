package com.efhem.binlist.cache.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.binlist.cache.model.CardInfoCacheModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardInfo(cardInfoCacheModel: CardInfoCacheModel)

    @Query("SELECT * FROM CARD_INFO")
    fun searches(): Flow<List<CardInfoCacheModel>>

    @Query("DELETE FROM CARD_INFO")
    fun clearHistory()
}