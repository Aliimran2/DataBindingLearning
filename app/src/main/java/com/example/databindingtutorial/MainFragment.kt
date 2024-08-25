package com.example.databindingtutorial

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.databindingtutorial.model.Product
import com.example.databindingtutorial.viewmodels.MainViewModel
import java.io.IOException


class MainFragment : Fragment() {

    private lateinit var tv_name: TextView
    private lateinit var tv_price :TextView
    private lateinit var tv_description :TextView
    private lateinit var tv_num_rating : TextView
    private lateinit var iv_product_sale : ImageView
    private lateinit var iv_product : ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val mViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        tv_name = view.findViewById(R.id.tv_name)
        tv_price = view.findViewById(R.id.tv_price)
        tv_description = view.findViewById(R.id.tv_description)
        tv_num_rating = view.findViewById(R.id.tv_num_rating)
        iv_product_sale = view.findViewById(R.id.iv_product_sale)
        iv_product = view.findViewById(R.id.iv_product)

        setData(mViewModel.getProduct())

        return view
    }
    fun setData(product: Product) {
        tv_name.text = product.name
        tv_price.text = "${product.price}$"
        tv_num_rating.text ="(${product.totalRatings})"
        tv_description.text = product.description

        iv_product.setImageBitmap(getBitMapFromAssets(product.image))
        iv_product_sale.visibility = if (product.salePrice > 0.0) View.VISIBLE else View.GONE


    }

    private fun getBitMapFromAssets(image: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(context?.assets?.open(image))
        } catch (e : IOException){
            e.printStackTrace()
            null
        }
    }


}