package com.example.feature_profile_screen.domain.use_case

import com.example.core.database.UserAccountDB
import com.example.feature_profile_screen.domain.repository.ProfileRepository

class DeleteUserAccountUseCase(private val profileRepository: ProfileRepository) {
	suspend operator fun invoke(userAccount: UserAccountDB){
		 profileRepository.deleteDataAccount(userAccount)
	}
}