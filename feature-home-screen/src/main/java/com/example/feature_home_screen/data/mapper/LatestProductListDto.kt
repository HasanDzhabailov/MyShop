package com.example.feature_home_screen.data.mapper


import com.example.feature_home_screen.domain.model.LatestProductList
import com.google.gson.annotations.SerializedName

data class LatestProductListDto(
	@SerializedName("latest")
	val latest: List<LatestProductDto>,
)

fun LatestProductListDto.toLatestListProduct(): LatestProductList = LatestProductList(
	latest.map { it.toLatestProduct() }
)