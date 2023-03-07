package com.example.feature_login_screen.domain.repository

interface LoginInRepository {
	suspend fun loginIn(firstName: String,password: String):Boolean
}