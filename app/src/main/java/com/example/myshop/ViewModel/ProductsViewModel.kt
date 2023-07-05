package com.example.myshop.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshop.Model.Product
import com.example.myshop.Repository.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
    var productsRepo= ProductsRepository()
    var productsLiveData= MutableLiveData<List<Product>>()
    var errorLiveData= MutableLiveData<String>()

    fun fetchProducts(){
        viewModelScope.launch {
            val response= productsRepo.getProducts()
            if (response.isSuccessful){
                productsLiveData.postValue(response.body()?.products)
            }
            else{
                errorLiveData.postValue((response.errorBody()?.string()))
            }
        }
    }
}