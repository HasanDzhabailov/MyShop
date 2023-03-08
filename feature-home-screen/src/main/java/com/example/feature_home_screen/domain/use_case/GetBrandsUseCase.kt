package com.example.feature_home_screen.domain.use_case

import com.example.feature_home_screen.domain.model.ItemBrand

import com.example.feature_home_screen.domain.repository.HomeRepository

class GetBrandsUseCase(private val homeRepository: HomeRepository) {
	operator fun invoke(): List<ItemBrand> {
		return homeRepository.getBrands()
	}
}