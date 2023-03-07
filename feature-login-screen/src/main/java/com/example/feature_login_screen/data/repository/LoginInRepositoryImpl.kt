package com.example.feature_login_screen.data.repository

import com.example.core.database.UsersAccountsDao
import com.example.feature_login_screen.domain.repository.LoginInRepository

class LoginInRepositoryImpl(private val usersAccountsDao: UsersAccountsDao): LoginInRepository {
	override suspend fun loginIn(firstName: String, password: String): Boolean {
		return usersAccountsDao.checkLoginIn(firstName,password).isNotEmpty()
	}
}