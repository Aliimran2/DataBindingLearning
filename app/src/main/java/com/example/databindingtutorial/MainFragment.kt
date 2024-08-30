package com.example.databindingtutorial

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databindingtutorial.databinding.FragmentMainBinding
import com.example.databindingtutorial.model.Product
import com.example.databindingtutorial.viewmodels.MainViewModel
import java.io.IOException


class MainFragment : Fragment() {

    private lateinit var iv_product_sale: ImageView
    private lateinit var iv_product: ImageView

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        val mViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        iv_product = binding.ivProduct

        binding.product = mViewModel.getProduct()

        return binding.root
    }


}