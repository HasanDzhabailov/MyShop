package com.example.core.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_accounts_table")
data class UsersAccountsEntities(
	@PrimaryKey(autoGenerate = true) var id:Int,
	val firstName:String,
	val lastName:String,
	val email:String,
	val photo:String
)