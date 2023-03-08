package com.example.core.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UsersAccountsDao {
	@Query("SELECT * FROM users_accounts_table WHERE email=:email ")
	suspend fun checkAuthUser(email: String): List<UserAccountDB>

	@Query("SELECT * FROM users_accounts_table WHERE email=:password AND firstName=:firstName ")
	suspend fun checkLoginIn(firstName: String, password: String): List<UserAccountDB>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun createUserAccount(UsersAccounts: UserAccountDB)

	@Update
	suspend fun uploadPhoto(UsersAccounts: UserAccountDB)

	@Delete
	suspend fun deleteUser(accountDbModel: UserAccountDB)

	@Query("SELECT * FROM users_accounts_table WHERE email LIKE '%' || :email || '%'")
	fun checkEmail(email: String): LiveData<UserAccountDB?>
}