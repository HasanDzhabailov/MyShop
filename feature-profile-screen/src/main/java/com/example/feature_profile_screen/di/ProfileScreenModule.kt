package com.example.feature_profile_screen.di

import com.example.core.database.UsersAccountsDao
import com.example.core.database.UsersDatabase
import com.example.feature_profile_screen.data.repository.ProfileRepositoryImpl
import com.example.feature_profile_screen.domain.repository.ProfileRepository
import com.example.feature_profile_screen.domain.use_case.DeleteUserAccountUseCase
import com.example.feature_profile_screen.domain.use_case.GetUserAccountUseCase
import com.example.feature_profile_screen.presentation.ProfileViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileScreenModule = module {
	single<UsersAccountsDao> {
		val database = get<UsersDatabase>()
		database.UsersAccountsDao()
	}
	single<ProfileRepository> {
		ProfileRepositoryImpl(usersAccountsDao = get())
	}

	factory { DeleteUserAccountUseCase(get()) }
	factory { GetUserAccountUseCase(get()) }

	viewModel {
		ProfileViewModel(
			application = androidApplication(),
			getUserAccountUseCase = get(),
			deleteUserAccountUseCase = get()
		)
	}

}