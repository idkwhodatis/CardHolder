package com.example.cardholder

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.zxing.Result

@Entity(tableName = "Cards")
data class Card(
    @PrimaryKey(autoGenerate = true) val cid: Int,
    @ColumnInfo(name = "cardName") var cardName: String?,
    @ColumnInfo(name = "logo") var logo: Bitmap?,
    @ColumnInfo(name = "bgColor") var bgColor: String?,
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "format") var format: String
)