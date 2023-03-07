package com.example.core.database

import androidx.room.*


@Dao
interface UsersAccountsDao {
	@Query("SELECT * FROM users_accounts_table WHERE email=:email ")
	suspend fun checkAuthUser(email:String): List<UserAccountDB>
	@Query("SELECT * FROM users_accounts_table WHERE email=:password AND firstName=:firstName ")
	suspend fun checkLoginIn(firstName:String,password:String): List<UserAccountDB>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun createUserAccount(UsersAccounts: UserAccountDB)

	@Update
	suspend fun uploadPhoto(UsersAccounts: UserAccountDB)

	@Delete
	suspend fun removeUser(accountDbModel: UserAccountDB)
}