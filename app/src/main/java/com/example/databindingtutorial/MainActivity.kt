package com.example.databindingtutorial

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.databindingtutorial.adapters.ProductsAdapter
import com.example.databindingtutorial.databinding.ActivityMainBinding
import com.example.databindingtutorial.model.DataProvider


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.setVariable(BR.dataList, DataProvider.productList)

    }
}