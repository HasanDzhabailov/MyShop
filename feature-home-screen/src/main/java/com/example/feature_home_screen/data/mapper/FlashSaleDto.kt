
package com.example.feature_home_screen.data.mapper

import com.example.feature_home_screen.domain.model.FlashProduct
import com.google.gson.annotations.SerializedName



data class FlashSaleDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("image_url")
    val image_url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double
)

fun FlashSaleDto.toFlashProduct():FlashProduct = FlashProduct(
    category = category,
    discount = discount,
    image_url = image_url,
    name = name,
    price = price
)