package com.example.feature_sign_in_screen.data.repository


import com.example.core.local.UserAccountDB
import com.example.core.local.UsersAccountsDao
import com.example.feature_sign_in_screen.domain.model.UsersAccount
import com.example.feature_sign_in_screen.domain.repository.SignInRepository

class SignInRepositoryImpl(private val usersAccountsDao: UsersAccountsDao) : SignInRepository {
	override suspend fun checkAuthUser(email:String): Boolean {
		val userAccount = usersAccountsDao.checkAuthUser(email)
		return userAccount.isNotEmpty()
	}

	override suspend fun createUserAccount(usersAccount: UsersAccount) {
		usersAccountsDao.createUserAccount(
			UserAccountDB(
				firstName=  usersAccount.firstName,
				lastName = usersAccount.lastName,
				email = usersAccount.email,
			)
		)
	}
}