package com.example.feature_home_screen.domain.repository

import com.example.feature_home_screen.domain.model.FlashSaleList
import com.example.feature_home_screen.domain.model.ItemCategory
import com.example.feature_home_screen.domain.model.LatestProductList

interface HomeRepository {
	suspend fun getFlashSaleList(): FlashSaleList
	suspend fun getLatestProducts(): LatestProductList
	fun getCategoryProducts(): List<ItemCategory>
}