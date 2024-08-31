package com.example.databindingtutorial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtutorial.databinding.ProductItemBinding
import com.example.databindingtutorial.model.Product

class ProductsAdapter(
    private val dataList: List<Product>
) : RecyclerView.Adapter<ProductsAdapter.BindingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder = BindingViewHolder.inflateFrom(parent)
    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val currentProduct = dataList[position]
        holder.bind(currentProduct)
        holder.binding.executePendingBindings()
    }

    class BindingViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): BindingViewHolder {
                val inflater = LayoutInflater.from(parent.context)
//                val view = ProductItemBinding.inflate(inflater, parent, false)
                val view:ViewDataBinding = ProductItemBinding.inflate(inflater, parent, false)
                return BindingViewHolder(view)
            }
        }

        fun bind(product: Product){
            binding.setVariable(BR.productItem, product)
        }
    }


}