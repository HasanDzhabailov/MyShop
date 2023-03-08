package com.example.feature_home_screen.data.network


import com.example.feature_home_screen.data.mapper.FlashSaleListDto
import com.example.feature_home_screen.data.mapper.LatestProductListDto


import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
	@GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
	suspend fun getLatestProducts(): Response<LatestProductListDto>

	@GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
	suspend fun getSaleFashProducts(): Response<FlashSaleListDto>
}