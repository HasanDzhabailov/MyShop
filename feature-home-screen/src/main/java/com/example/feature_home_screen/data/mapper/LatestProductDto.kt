package com.example.feature_home_screen.data.mapper

import com.example.feature_home_screen.domain.model.LatestProduct
import com.google.gson.annotations.SerializedName
import java.util.*

data class LatestProductDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("image_url")
    val image_url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
)

fun LatestProductDto.toLatestProduct(): LatestProduct = LatestProduct(
	category = category,
	image_urls = image_url,
	name = name,
	price = price,
	id = UUID.randomUUID()
)