package com.example.feature_product_details_screen.domain.repository

import com.example.feature_product_details_screen.domain.model.ItemProduct

interface ProductDetailsRepository {
	suspend fun getProductDetails(): ItemProduct?
}