package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserAccountDB::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
	abstract fun UsersAccountsDao(): UsersAccountsDao
}