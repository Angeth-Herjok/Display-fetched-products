package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var productAdapter: ProductsAdapter
    var productList: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductsAdapter(emptyList())
        binding.rvProductsItem.adapter = productAdapter

    }


    override fun onResume() {
        super.onResume()
        getProducts()
    }


    fun getProducts() {
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getProducts()
        request.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    var productResponse = response.body()?.products

                    var productAdapter=ProductsAdapter(productResponse?: emptyList())
                    binding.rvProductsItem.layoutManager= LinearLayoutManager(this@MainActivity)
                    binding.rvProductsItem.adapter=productAdapter

                    Toast
                        .makeText(
                            baseContext,
                            "fetched ${productList?.size} products",
                            Toast.LENGTH_LONG
                        )
                        .show()

                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG)
                        .show()
                }

            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}












