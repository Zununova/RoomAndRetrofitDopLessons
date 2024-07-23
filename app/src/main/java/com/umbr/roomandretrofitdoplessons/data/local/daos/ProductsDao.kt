package com.umbr.roomandretrofitdoplessons.data.local.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.umbr.roomandretrofitdoplessons.data.local.models.ProductEntities

@Dao
interface ProductsDao {

    // добовление
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(productEntities: ProductEntities)

    // получение
    @Query("SELECT * FROM ProductEntities")
    fun fetchProducts() : LiveData<List<ProductEntities>>

    // удаление
    @Delete
    fun deleteProduct(productEntities: ProductEntities)
}