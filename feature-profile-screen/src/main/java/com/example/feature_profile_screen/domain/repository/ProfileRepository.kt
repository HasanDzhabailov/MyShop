package com.example.feature_profile_screen.domain.repository

import androidx.lifecycle.LiveData
import com.example.core.database.UserAccountDB

interface ProfileRepository {
	fun getDataAccount(email: String): LiveData<UserAccountDB?>
	suspend fun deleteDataAccount(userAccount: UserAccountDB)
}