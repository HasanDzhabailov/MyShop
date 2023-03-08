package com.example.feature_product_details_screen.data.mapper

import com.example.feature_product_details_screen.domain.model.ItemProduct
import com.google.gson.annotations.SerializedName

class ItemProductDto(
    @SerializedName("colors")
    val colors: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_urls")
    val image_urls: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_reviews")
    val number_of_reviews: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
)

fun ItemProductDto.toItemProduct(): ItemProduct = ItemProduct(
	colors = colors,
	description = description,
	image_urls = image_urls,
	name = name,
	number_of_reviews = number_of_reviews,
	price = price,
	rating = rating
)