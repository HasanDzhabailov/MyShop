package com.example.myshop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.local.UsersAccountsEntities


@Database(entities = [UsersAccountsEntities::class], version = 1, exportSchema = false)
abstract class UsersDatabase:RoomDatabase(){
	abstract fun UsersAccountsDao():UsersAccountsDao
}