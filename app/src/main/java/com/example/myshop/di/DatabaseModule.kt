package com.example.myshop.di

import androidx.room.Room
import com.example.core.database.UsersDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
	single {
		Room.databaseBuilder(
			androidContext(), UsersDatabase::class.java, "my_shop.db"
		).build()
	}
}