package com.example.myshop.Ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.ViewModel.QuotesViewModel
import com.example.myshop.databinding.ActivityQuotesBinding

class Quotes : AppCompatActivity() {
    val quotesViewModel: QuotesViewModel by ViewModel()

    lateinit var binding: ActivityQuotesBinding
    lateinit var quotesAdapter: QuotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        quotesViewModel.fetchQuotes()

        quotesViewModel.quotesLiveData
            .observe(this, Observer { quotes ->
                getQuotes(  quotes)

            })
        quotesViewModel.errorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()

        })
    }

    fun getQuotes(quotes: List<com.example.myshop.Ui.Quotes>) {
        quotesAdapter= QuotesAdapter(quotes)
        binding.rvQuotes.layoutManager= LinearLayoutManager(this@Quotes)
        binding.rvQuotes.adapter=quotesAdapter

    }

}
