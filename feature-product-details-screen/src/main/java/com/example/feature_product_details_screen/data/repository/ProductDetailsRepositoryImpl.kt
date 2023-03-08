package com.example.feature_product_details_screen.data.repository

import com.example.feature_product_details_screen.data.mapper.toItemProduct
import com.example.feature_product_details_screen.domain.model.ItemProduct
import com.example.feature_product_details_screen.domain.repository.ProductDetailsRepository
import com.example.feature_product_details_screen.data.network.ProductDetailsApi

class ProductDetailsRepositoryImpl(private val productDetailsApi: ProductDetailsApi) :
	ProductDetailsRepository {
	override suspend fun getProductDetails(): ItemProduct? {
		val itemDetailsProduct = productDetailsApi.getItemProduct().body()?.let {
			it.toItemProduct()
		}
		return itemDetailsProduct
	}

}