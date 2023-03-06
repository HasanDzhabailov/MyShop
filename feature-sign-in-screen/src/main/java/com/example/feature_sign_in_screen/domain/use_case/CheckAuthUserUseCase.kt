package com.example.feature_sign_in_screen.domain.use_case

import com.example.feature_sign_in_screen.domain.repository.SignInRepository

class CheckAuthUserUseCase(private val singInRepository: SignInRepository) {
	 suspend operator  fun invoke(email:String): Boolean {
		return singInRepository.checkAuthUser(email)
	}
}