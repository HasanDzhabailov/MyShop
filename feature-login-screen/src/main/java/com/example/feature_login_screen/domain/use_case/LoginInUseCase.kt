package com.example.feature_login_screen.domain.use_case

import com.example.feature_login_screen.domain.repository.LoginInRepository

class LoginInUseCase(private val loginInRepository: LoginInRepository) {
	suspend operator  fun invoke(firstName:String, password:String): Boolean {
		return loginInRepository.loginIn(firstName,password)
	}
}