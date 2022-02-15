package com.example.cardholder

import androidx.room.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@Dao
interface CardDao {
    @Query("SELECT * FROM cards ORDER BY cid ASC")
    fun getAllCards(): Flow<List<Card>>

    @Insert
    suspend fun insertCard(cards: Card)

    @Update
    suspend fun updateUsers(card: Card)

    @Delete
    suspend fun deleteCard(card: Card)

    @Query("SELECT * FROM cards WHERE cid = :cid")
    suspend fun findCardById(cid: Int): Card

    @Query("SELECT * FROM cards WHERE cardName LIKE :cname LIMIT 1")
    suspend fun findCardByName(cname: String): Card
}