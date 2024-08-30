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
import com.example.databindingtutorial.model.Product

class ProductsAdapter(
    private val context: Context,
    private val dataList: List<Product>
):RecyclerView.Adapter<ProductsAdapter.ProductVH>() {

    class ProductVH(productItem:View):RecyclerView.ViewHolder(productItem){
        val productName = productItem.findViewById<TextView>(R.id.tv_name)
        val productPrice = productItem.findViewById<TextView>(R.id.tv_price)
        val productRating = productItem.findViewById<RatingBar>(R.id.rating_bar)
        val productTotalRating = productItem.findViewById<TextView>(R.id.tv_num_rating)
        val productImage = productItem.findViewById<ImageView>(R.id.iv_product)
        val productImgSale = productItem.findViewById<ImageView>(R.id.iv_product_sale)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ProductVH(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val currentProduct = dataList[position]
        holder.productName.text = currentProduct.name
        holder.productPrice.text = "${currentProduct.price}$"
        holder.productTotalRating.text = "(${currentProduct.totalRatings})"
        holder.productRating.rating = currentProduct.rating

        try {
            val bitmap= BitmapFactory.decodeStream(context.assets?.open(currentProduct.image))
            holder.productImage.setImageBitmap(bitmap)
        } catch (e: Exception){
            e.printStackTrace()
        }

        holder.productImgSale.visibility = if (currentProduct.salePrice > 0.0) VISIBLE else GONE


    }
}