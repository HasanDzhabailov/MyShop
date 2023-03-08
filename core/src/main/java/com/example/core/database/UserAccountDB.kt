package com.example.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_accounts_table")
data class UserAccountDB(
	@PrimaryKey
	var email: String = "s",
	val firstName: String = "",
	val lastName: String = "",
	)
