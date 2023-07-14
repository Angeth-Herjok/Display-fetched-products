package com.example.myshop.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myshop.Model.Quotes
import com.example.myshop.Repository.QuotesRepository
import kotlinx.coroutines.launch


class QuotesViewModel () {
    var quotesRepo = QuotesRepository()
    var quotesLiveData = MutableLiveData<List<Quotes>>()
    var errorLiveData = MutableLiveData<String>()

    suspend fun fetchQuotes() {


        viewModelScope.launch {this
            val response= quotesRepo.getQuotes()
            if (response.isSuccessful){
                quotesLiveData.postValue(response.body()?.quotes)
            }
            else{
                errorLiveData.postValue((response.errorBody()?.string()))
            }
        }
    }
    }
