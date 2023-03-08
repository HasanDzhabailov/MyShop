package com.example.feature_home_screen.domain.use_case

import com.example.feature_home_screen.domain.model.FlashSaleList
import com.example.feature_home_screen.domain.repository.HomeRepository

class GetFlashSaleProductsUseCase(private val homeRepository: HomeRepository) {
	suspend operator fun invoke(): FlashSaleList {
		return homeRepository.getFlashSaleList()
	}
}