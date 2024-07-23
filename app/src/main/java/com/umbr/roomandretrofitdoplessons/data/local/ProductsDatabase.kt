package com.umbr.roomandretrofitdoplessons.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.umbr.roomandretrofitdoplessons.data.local.daos.ProductsDao
import com.umbr.roomandretrofitdoplessons.data.local.models.ProductEntities

@Database(entities = [ProductEntities::class], version = 3)
abstract class ProductsDatabase : RoomDatabase() {
    abstract val productsDao: ProductsDao
}