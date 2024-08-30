package com.example.databindingtutorial.utils

object StringUtils {

    @JvmStatic
    fun formattedPrice(price :Double ):String {
        return "$price$"
    }

    @JvmStatic
    fun formattedRating(rating: Int):String{
        return "($rating)"
    }
}