package com.example.feature_profile_screen.domain.use_case

import androidx.lifecycle.LiveData
import com.example.core.database.UserAccountDB
import com.example.feature_profile_screen.domain.repository.ProfileRepository

class GetUserAccountUseCase(private val profileRepository: ProfileRepository) {
	operator fun invoke(email:String):LiveData<UserAccountDB?>{
		return profileRepository.getDataAccount(email)
	}
}