package com.example.myshop.Ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.Model.Product
import com.example.myshop.databinding.ItemProductBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation


class ProductsAdapter (var productList:List<Product>):RecyclerView.Adapter<ProductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ItemProductBinding .inflate(LayoutInflater.from(parent.context),parent ,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct =productList[position]
        var  binding=holder.binding
        binding.tvId.text=currentProduct.id.toString()
        binding.tvTitle.text=currentProduct.title.toString()
        binding.tvDescription.text=currentProduct.description.toString()
        binding.tvPrice.text=currentProduct.price.toString()
        binding.tvRating.text=currentProduct.rating.toString()
        binding.tvStock.text=currentProduct.stock.toString()
        binding.tvCategory.text=currentProduct.category.toString()
        binding.tvBrand.text=currentProduct.brand.toString()

        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .transform(CropCircleTransformation())
            .into(binding.ivThumbnail)

    }
    override fun getItemCount(): Int {
        return productList.size
    }
}
class ProductViewHolder( var binding:ItemProductBinding): RecyclerView.ViewHolder(binding.root)










