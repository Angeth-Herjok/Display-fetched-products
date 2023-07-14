package com.example.myshop.Ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class QuotesAdapter (var quotes:List<Quotes>):RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val binding =
            ItemQuotesBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return QuotesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        var currentQuotes =quotes[position]
        var  binding=holder.binding

        binding.tvId.text=currentQuotes.id.toString()
        binding.tvQuote.text=currentQuotes.quote.toString()
        binding.tvAuthor.text=currentQuotes.author.toString()


        Picasso
            .get()
            .load(currentQuotes.image)
            .transform(CropCircleTransformation())
            .into(binding.ivThumbnail)

    }

    override fun getItemCount(): Int {
        return quotes.size


    }

    class QuotesViewHolder(var binding: ItemQuotesBinding) : RecyclerView.ViewHolder(binding.root)
}

