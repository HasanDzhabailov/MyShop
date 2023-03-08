package com.example.feature_home_screen.domain.use_case

import com.example.feature_home_screen.domain.model.ItemCategory
import com.example.feature_home_screen.domain.repository.HomeRepository

class GetCategoryProductsUseCase(private val homeRepository: HomeRepository) {
	operator fun invoke(): List<ItemCategory> {
		return homeRepository.getCategoryProducts()
	}
}