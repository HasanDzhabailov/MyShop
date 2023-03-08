package com.example.feature_product_details_screen.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_product_details_screen.R
import com.example.feature_product_details_screen.domain.model.ItemProduct
import com.example.feature_product_details_screen.domain.use_case.GetProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
	application: Application,
	private val getProductUseCase: GetProductUseCase,
) : AndroidViewModel(application) {
	private val context = application

	private var _itemProduct = MutableLiveData<ItemProduct>()
	val itemProduct: LiveData<ItemProduct> = _itemProduct

	private var _itemProductError = MutableLiveData<String>()
	val itemProductError: LiveData<String> = _itemProductError

	init {
		getItemProduct()
	}

	private fun getItemProduct() {
		viewModelScope.launch(Dispatchers.IO) {
			try {
				getProductUseCase()?.let {
					_itemProduct.postValue(it)
				}
			} catch (e: Exception) {
				_itemProductError.postValue(
					String.format(
						context.getString(R.string.error_item_product), e.message
					)
				)
			}
		}
	}
}