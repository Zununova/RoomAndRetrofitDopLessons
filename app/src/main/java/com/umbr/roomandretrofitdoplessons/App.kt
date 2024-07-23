package com.umbr.roomandretrofitdoplessons

import android.app.Application
import androidx.room.Room
import com.umbr.roomandretrofitdoplessons.data.local.ProductsDatabase

class App : Application() {

    companion object {
        var productDatabase: ProductsDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        productDatabase = Room.databaseBuilder(
            applicationContext,
            ProductsDatabase::class.java,
            "product data base"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}