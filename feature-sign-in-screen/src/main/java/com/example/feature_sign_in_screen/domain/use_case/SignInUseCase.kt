package com.example.feature_sign_in_screen.domain.use_case

import com.example.feature_sign_in_screen.domain.model.UsersAccount
import com.example.feature_sign_in_screen.domain.repository.SignInRepository

class SignInUseCase(private val singInRepository: SignInRepository) {
	suspend operator fun invoke(usersAccount: UsersAccount){
		return singInRepository.createUserAccount(usersAccount)
	}
}