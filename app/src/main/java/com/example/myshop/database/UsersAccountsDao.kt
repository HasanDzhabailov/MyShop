package com.example.myshop.database

import androidx.room.*
import com.example.core.local.UsersAccountsEntities

@Dao
interface UsersAccountsDao {
	@Query("SELECT * FROM users_accounts_table WHERE email=:email ")
	suspend fun checkAuthUser(email:String)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun createUserAccount(UsersAccounts: UsersAccountsEntities)

	@Update
	suspend fun uploadPhoto(UsersAccounts: UsersAccountsEntities)

	@Delete
	suspend fun removeUser(accountDbModel: UsersAccountsEntities)
}