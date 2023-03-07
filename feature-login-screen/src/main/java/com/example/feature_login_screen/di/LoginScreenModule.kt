package com.example.feature_login_screen.di

import com.example.core.database.UsersAccountsDao
import com.example.core.database.UsersDatabase
import com.example.feature_login_screen.data.repository.LoginInRepositoryImpl
import com.example.feature_login_screen.domain.repository.LoginInRepository
import com.example.feature_login_screen.domain.use_case.LoginInUseCase
import com.example.feature_login_screen.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginScreenModule = module {
	single<UsersAccountsDao> {
		val database = get<UsersDatabase>()
		database.UsersAccountsDao()
	}
	single<LoginInRepository> {
		LoginInRepositoryImpl(usersAccountsDao = get())
	}
	factory { LoginInUseCase(get()) }
	viewModel {
		LoginViewModel(loginInUseCase = get())
	}
}