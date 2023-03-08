package com.example.feature_product_details_screen.di

import com.example.feature_product_details_screen.data.network.ProductDetailsApi
import com.example.feature_product_details_screen.data.repository.ProductDetailsRepositoryImpl
import com.example.feature_product_details_screen.domain.repository.ProductDetailsRepository
import com.example.feature_product_details_screen.domain.use_case.GetProductUseCase
import com.example.feature_product_details_screen.presentation.ProductDetailsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val productDetailsScreenModule = module {
	single { provideProductDetailsService(retrofit = get()) }
	single<ProductDetailsRepository> { ProductDetailsRepositoryImpl(productDetailsApi = get()) }

	factory { GetProductUseCase(get()) }

	viewModel {
		ProductDetailsViewModel(
			application = androidApplication(), getProductUseCase = get()
		)
	}

}

fun provideProductDetailsService(retrofit: Retrofit): ProductDetailsApi =
	retrofit.create(ProductDetailsApi::class.java)