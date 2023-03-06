package com.example.feature_sign_in_screen.domain.repository

import com.example.feature_sign_in_screen.domain.model.UsersAccount

interface SignInRepository {
	suspend fun checkAuthUser(email: String):Boolean
	suspend fun createUserAccount(usersAccount: UsersAccount)
}