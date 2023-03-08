package com.example.feature_profile_screen.data.repository

import androidx.lifecycle.LiveData
import com.example.core.database.UserAccountDB
import com.example.core.database.UsersAccountsDao
import com.example.feature_profile_screen.domain.repository.ProfileRepository

class ProfileRepositoryImpl(
	private val usersAccountsDao: UsersAccountsDao,
):ProfileRepository {
	override fun getDataAccount(email: String): LiveData<UserAccountDB?> {
		return usersAccountsDao.checkEmail(email)
	}

	override suspend fun deleteDataAccount(userAccount: UserAccountDB) {
		usersAccountsDao.deleteUser(userAccount)
	}
}