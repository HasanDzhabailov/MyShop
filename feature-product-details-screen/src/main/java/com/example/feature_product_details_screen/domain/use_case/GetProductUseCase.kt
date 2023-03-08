package com.example.feature_product_details_screen.domain.use_case

import com.example.feature_product_details_screen.domain.model.ItemProduct
import com.example.feature_product_details_screen.domain.repository.ProductDetailsRepository

class GetProductUseCase(private val productDetailsRepository: ProductDetailsRepository) {
	suspend operator fun invoke(): ItemProduct? {
		return productDetailsRepository.getProductDetails()
	}
}