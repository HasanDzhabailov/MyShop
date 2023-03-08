package com.example.core.database

import android.content.Context


fun saveAuthUser(context: Context, email: String) {
	val sharedPref =
		context.getSharedPreferences(SharedPref.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)
	with(sharedPref.edit()) {
		putString(SharedPref.EMAIL_USER_KEY, email)
		apply()
	}
}

fun removeAuthUser(context: Context) {
	val sharedPref = context.getSharedPreferences("PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
	with(sharedPref.edit()) {
		putString("EMAIL_USER_KEY", SharedPref.DEFAULT_VALUE_EMAIL)
		apply()
	}
}

object SharedPref {
	const val PREFERENCE_FILE_KEY = "PREFERENCE_FILE_KEY"
	const val EMAIL_USER_KEY = "EMAIL_USER_KEY"
	const val DEFAULT_VALUE_EMAIL = ""
}
