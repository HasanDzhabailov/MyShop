package com.example.feature_home_screen.domain.use_case

import com.example.feature_home_screen.domain.model.LatestProductList
import com.example.feature_home_screen.domain.repository.HomeRepository

class GetLatestProductsUseCase(private val homeRepository: HomeRepository) {
	suspend operator fun invoke(): LatestProductList {
		return homeRepository.getLatestProducts()
	}
}