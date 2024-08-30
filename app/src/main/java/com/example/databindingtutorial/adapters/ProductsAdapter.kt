package com.example.databindingtutorial.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtutorial.R
import com.example.databindingtutorial.databinding.ProductItemBinding
import com.example.databindingtutorial.model.Product

class ProductsAdapter(
    private val context: Context,
    private val dataList: List<Product>
):RecyclerView.Adapter<ProductsAdapter.BindingViewHolder>() {

    class BindingViewHolder(val binding: ProductItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val view = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return BindingViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val currentProduct = dataList[position]
        holder.binding.productItem = currentProduct
        holder.binding.executePendingBindings()
    }

//    fun updateDataList(data:)
}