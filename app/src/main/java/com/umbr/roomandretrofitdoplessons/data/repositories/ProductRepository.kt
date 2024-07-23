package com.umbr.roomandretrofitdoplessons.data.repositories

import com.umbr.roomandretrofitdoplessons.App
import com.umbr.roomandretrofitdoplessons.data.local.models.ProductEntities

class ProductRepository {

    fun addProduct(productEntities: ProductEntities) {
        App.productDatabase?.productsDao?.addProduct(productEntities)
    }

    fun fetchProducts() = App.productDatabase?.productsDao?.fetchProducts()

    fun deleteProduct(productEntities: ProductEntities) {
        App.productDatabase?.productsDao?.deleteProduct(productEntities)
    }
}