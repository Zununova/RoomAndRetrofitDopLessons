package com.umbr.roomandretrofitdoplessons.ui.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umbr.roomandretrofitdoplessons.data.local.models.ProductEntities
import com.umbr.roomandretrofitdoplessons.data.repositories.ProductRepository

class MainViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private var _productsList = MutableLiveData<List<ProductEntities>>()
    val productList: LiveData<List<ProductEntities>>? = productRepository.fetchProducts()

    init {
        fetchProducts()
    }

    fun addProduct(productEntities: ProductEntities) {
        productRepository.addProduct(productEntities)
    }

    fun delateProduct(productEntities: ProductEntities) {
        productRepository.deleteProduct(productEntities)
    }

    private fun fetchProducts() {
        _productsList.value = productRepository.fetchProducts()?.value
    }
}