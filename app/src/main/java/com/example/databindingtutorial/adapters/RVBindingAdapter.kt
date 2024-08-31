package com.example.databindingtutorial.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtutorial.model.Product

@BindingAdapter("dataBind")
fun RecyclerView.dataBind(dataList:List<Product>){

    if (dataList.isEmpty())
        return

    var productAdapter = this.adapter
    if(productAdapter == null){
        productAdapter = ProductsAdapter(dataList)
        this.adapter  = productAdapter
    }

}
