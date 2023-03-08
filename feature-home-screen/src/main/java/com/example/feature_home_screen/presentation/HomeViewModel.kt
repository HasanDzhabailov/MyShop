package com.example.feature_home_screen.presentation

import android.app.Application
import androidx.lifecycle.*
import com.example.feature_home_screen.R
import com.example.feature_home_screen.domain.model.FlashSaleList
import com.example.feature_home_screen.domain.model.ItemCategory
import com.example.feature_home_screen.domain.model.LatestProductList
import com.example.feature_home_screen.domain.use_case.GetCategoryProductsUseCase
import com.example.feature_home_screen.domain.use_case.GetFlashSaleProductsUseCase
import com.example.feature_home_screen.domain.use_case.GetLatestProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(

	private val getLatestProductsUseCase: GetLatestProductsUseCase,
	private val getFlashSaleProductsUseCase: GetFlashSaleProductsUseCase,
	private val getCategoryProductsUseCase: GetCategoryProductsUseCase,
	application: Application,

): AndroidViewModel(application) {
	private val context = application

	private var _listCategory = MutableLiveData<List<ItemCategory>>()
	val listCategory: LiveData<List<ItemCategory>> = _listCategory

	private var _listCategoryError = MutableLiveData<String>()
	val listCategoryError: LiveData<String> = _listCategoryError

	private var _listLatest = MutableLiveData<LatestProductList>()
	val listLatest: LiveData<LatestProductList> = _listLatest

	private var _listLatestError = MutableLiveData<String>()
	val listLatestError: LiveData<String> = _listLatestError

	private var _listSale = MutableLiveData<FlashSaleList>()
	val listSale: LiveData<FlashSaleList> = _listSale

	private var _listSaleError = MutableLiveData<String>()
	val listSaleError: LiveData<String> = _listSaleError

	private fun getLatestProducts() {
		viewModelScope.launch(Dispatchers.IO) {
			try {
				_listLatest.postValue(getLatestProductsUseCase() ?: LatestProductList(listOf()))
			} catch (e: Exception) {
				_listLatestError.postValue(
					String.format(
						context.getString(R.string.error_latest_products),
						e.message
					)
				)
			}

		}
	}
	private fun getCategories() {
		try {
			_listCategory.value = getCategoryProductsUseCase()
		} catch (e: Exception) {
			_listCategoryError.value = String.format(
				context.getString(R.string.error_list_category),
				e.message
			)
		}

	}

	init {
		getLatestProducts()
		getFlashSaleProducts()
		getCategories()
	}
	private fun getFlashSaleProducts() {
		viewModelScope.launch(Dispatchers.IO) {
			try {
				_listSale.postValue(getFlashSaleProductsUseCase() ?: FlashSaleList(listOf()))
			} catch (e: Exception) {
				_listSaleError.postValue(
					String.format(
						context.getString(R.string.error_sale_products),
						e.message
					)
				)
			}

		}
	}

}