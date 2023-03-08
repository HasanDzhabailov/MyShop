package com.example.feature_home_screen.data.repository

import android.content.Context
import com.example.feature_home_screen.R
import com.example.feature_home_screen.data.mapper.toFlashSaleList
import com.example.feature_home_screen.data.mapper.toLatestListProduct
import com.example.feature_home_screen.data.network.HomeApi
import com.example.feature_home_screen.domain.model.FlashSaleList
import com.example.feature_home_screen.domain.model.ItemBrand
import com.example.feature_home_screen.domain.model.ItemCategory
import com.example.feature_home_screen.domain.model.LatestProductList
import com.example.feature_home_screen.domain.repository.HomeRepository

class HomeRepositoryImpl(private val homeApi: HomeApi, private val context: Context) :
	HomeRepository {
	override suspend fun getFlashSaleList(): FlashSaleList {
		return homeApi.getSaleFashProducts().body()?.let { flashSaleListDto ->
			flashSaleListDto.toFlashSaleList()
		} ?: FlashSaleList(listOf())
	}

	override suspend fun getLatestProducts(): LatestProductList {
		return homeApi.getLatestProducts().body()?.let { latestProductListDto ->
			latestProductListDto.toLatestListProduct()
		} ?: LatestProductList(listOf())
	}

	override fun getCategoryProducts(): List<ItemCategory> {
		val listCategories = arrayListOf<ItemCategory>()
		listCategories.add(ItemCategory(context.getString(R.string.phones), R.drawable.ic_phones))
		listCategories.add(
			ItemCategory(
				context.getString(R.string.headphones),
				R.drawable.ic_headphones
			)
		)
		listCategories.add(ItemCategory(context.getString(R.string.games), R.drawable.ic_games))
		listCategories.add(ItemCategory(context.getString(R.string.cars), R.drawable.ic_cars))
		listCategories.add(
			ItemCategory(
				context.getString(R.string.furniture),
				R.drawable.ic_furniture
			)
		)
		listCategories.add(ItemCategory(context.getString(R.string.kids), R.drawable.ic_kids))
		return listCategories
	}

	override fun getBrands(): List<ItemBrand> {
		val listBrand = arrayListOf<ItemBrand>()
		listBrand.add(ItemBrand(R.drawable.ic_chanel_brend))
		listBrand.add(ItemBrand(R.drawable.ic_calvin_klein_brend))
		listBrand.add(ItemBrand(R.drawable.ic_hugo_boss_brend))
		return listBrand
	}
}