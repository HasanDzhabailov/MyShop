package com.example.feature_sign_in_screen.di

import com.example.core.local.UsersAccountsDao
import com.example.core.local.UsersDatabase
import com.example.feature_sign_in_screen.data.repository.SignInRepositoryImpl
import com.example.feature_sign_in_screen.domain.repository.SignInRepository
import com.example.feature_sign_in_screen.domain.use_case.CheckAuthUserUseCase
import com.example.feature_sign_in_screen.domain.use_case.SignInUseCase
import com.example.feature_sign_in_screen.presentation.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signInScreenModule = module {
	single<UsersAccountsDao>{
		val database = get<UsersDatabase>()
		database.UsersAccountsDao()
	}
	single <SignInRepository>{
		SignInRepositoryImpl(usersAccountsDao = get())
	}
	factory { SignInUseCase(get()) }
	factory { CheckAuthUserUseCase(get()) }
	viewModel{
		SignInViewModel(signInUseCase = get(), checkAuthUserUseCase = get())
	}


}
