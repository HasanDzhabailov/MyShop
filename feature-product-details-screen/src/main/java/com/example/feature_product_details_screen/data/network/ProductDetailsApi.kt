package com.example.feature_product_details_screen.data.network

import com.example.feature_product_details_screen.data.mapper.ItemProductDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductDetailsApi {
	@GET("f7f99d04-4971-45d5-92e0-70333383c239")
	suspend fun getItemProduct(): Response<ItemProductDto>
}