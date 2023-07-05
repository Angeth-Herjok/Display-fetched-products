package com.example.myshop.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.Api.ApiClient
import com.example.myshop.Api.ApiInterface
import com.example.myshop.Model.Product
import com.example.myshop.Model.ProductResponse
import com.example.myshop.ViewModel.ProductsViewModel
import com.example.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val productsViewModel: ProductsViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        productsViewModel.fetchProducts()

        productsViewModel.productsLiveData
            .observe(this, Observer { productList ->
                getProducts(productList)

            })
        productsViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()

        })
    }

    fun getProducts(product: List<Product>) {
        productAdapter= ProductsAdapter(product)
        binding.rvProductsItem.layoutManager= LinearLayoutManager(this@MainActivity)
        binding.rvProductsItem.adapter=productAdapter

    }

}














