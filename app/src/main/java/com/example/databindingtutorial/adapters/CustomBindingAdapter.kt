package com.example.databindingtutorial.adapters

import android.graphics.BitmapFactory
import android.icu.number.NumberFormatter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.databindingtutorial.R
import java.io.IOException
import java.text.NumberFormat
import java.util.Locale

@BindingAdapter("imageFromAssets")
fun ImageView.imageFromAssets(image: String){
    try {
        val bitmap = BitmapFactory.decodeStream(context?.assets?.open(image))
        this.setImageBitmap(bitmap)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

@BindingAdapter(value = ["imageFromUrl", "placeholderImage", "errorImage"], requireAll = false)
fun ImageView.imageFromUrl(url: String, placeholderImage: Boolean, errorImage: Boolean) {

    val requestOptions: RequestOptions = RequestOptions()
    if (placeholderImage)
        requestOptions.placeholder(R.drawable.placeholder)
    if (errorImage)
        requestOptions.error(R.drawable.error)

    Glide.with(this.context)
        .setDefaultRequestOptions(requestOptions)
        .load(url)
        .into(this)
}

@BindingAdapter("priceText")
fun TextView.format(price: Double){
    val formatter = NumberFormat.getCurrencyInstance(Locale.UK)
    text = "${formatter.format(price)}"
}

@BindingAdapter("ratingText")
fun TextView.ratingText(rating: Int){
    text = "{$rating}"
}