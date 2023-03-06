package com.example.core.local

import androidx.room.*


@Dao
interface UsersAccountsDao {
	@Query("SELECT * FROM users_accounts_table WHERE email=:email ")
	suspend fun checkAuthUser(email:String): List<UserAccountDB>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun createUserAccount(UsersAccounts: UserAccountDB)

	@Update
	suspend fun uploadPhoto(UsersAccounts: UserAccountDB)

	@Delete
	suspend fun removeUser(accountDbModel: UserAccountDB)
}