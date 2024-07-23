package com.umbr.roomandretrofitdoplessons.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.umbr.roomandretrofitdoplessons.data.local.models.ProductEntities
import com.umbr.roomandretrofitdoplessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var lastProudct: ProductEntities? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding.root)

        initialize()
        setupListeners()
    }

    private fun initialize() {
        viewModel.productList?.let { liveData ->
            liveData.observe(this) { productsList ->
                productsList?.let {
                    binding.tvProductsList.text = it.toString()
                    if (it.isNotEmpty()) {
                        lastProudct = it[0]
                    }
                }
            }
        }
    }

    private fun setupListeners() = with(binding) {
        val productEntities =
            ProductEntities(name = "Some product", prise = 1000000f, image = "image")
        btnAdd.setOnClickListener {
            viewModel.addProduct(productEntities)
        }

        btnDatate.setOnClickListener {
            lastProudct?.let {
                viewModel.delateProduct(it)
            }
        }
    }
}