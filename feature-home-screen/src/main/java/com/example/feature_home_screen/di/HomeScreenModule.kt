package com.example.feature_home_screen.di

import android.app.Application
import com.example.feature_home_screen.data.network.HomeApi
import com.example.feature_home_screen.data.repository.HomeRepositoryImpl
import com.example.feature_home_screen.domain.repository.HomeRepository
import com.example.feature_home_screen.domain.use_case.GetCategoryProductsUseCase
import com.example.feature_home_screen.domain.use_case.GetFlashSaleProductsUseCase
import com.example.feature_home_screen.domain.use_case.GetLatestProductsUseCase
import com.example.feature_home_screen.presentation.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeScreenModule = module {
	single { provideHomeService(retrofit = get()) }
	single<HomeRepository> { HomeRepositoryImpl(homeApi = get(), context = get()) }

	factory { GetFlashSaleProductsUseCase(get()) }
	factory { GetLatestProductsUseCase(get()) }
	factory { GetCategoryProductsUseCase(get()) }

	viewModel {
		HomeViewModel(
			getFlashSaleProductsUseCase = get(),
			getLatestProductsUseCase = get(),
			getCategoryProductsUseCase = get(),
			application = androidApplication()
		)
	}
}

fun provideHomeService(retrofit: Retrofit): HomeApi =
	retrofit.create(HomeApi::class.java)