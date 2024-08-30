package com.example.databindingtutorial.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtutorial.model.Product

@BindingAdapter("dataBind")
fun RecyclerView.dataBind(dataList:List<Product>){

    if (dataList.isEmpty())
        return

//    val layoutManager = this.layoutManager
//    if (layoutManager == null){
//        this.layoutManager = GridLayoutManager(this.context, 2)
//    }

    var productAdapter = this.adapter
    if(productAdapter == null){
        productAdapter = ProductsAdapter(this.context, dataList)
        this.adapter  = productAdapter
    }

}
