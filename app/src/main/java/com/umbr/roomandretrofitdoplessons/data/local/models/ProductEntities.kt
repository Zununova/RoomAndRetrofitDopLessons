package com.umbr.roomandretrofitdoplessons.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntities(
    val name: String,
    val prise: Float,
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}