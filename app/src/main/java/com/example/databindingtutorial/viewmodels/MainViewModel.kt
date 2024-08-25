package com.example.databindingtutorial.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.databindingtutorial.model.DataProvider
import com.example.databindingtutorial.model.Product

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var product = DataProvider.productList[0]

    fun getProduct(): Product = product

}
