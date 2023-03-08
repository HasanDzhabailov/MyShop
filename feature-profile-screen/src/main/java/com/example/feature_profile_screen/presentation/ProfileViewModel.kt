package com.example.feature_profile_screen.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.database.SharedPref
import com.example.core.database.SharedPref.DEFAULT_VALUE_EMAIL

import com.example.feature_profile_screen.domain.use_case.DeleteUserAccountUseCase
import com.example.feature_profile_screen.domain.use_case.GetUserAccountUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
	application: Application,
	private val getUserAccountUseCase: GetUserAccountUseCase,
	private val deleteUserAccountUseCase: DeleteUserAccountUseCase,
) : AndroidViewModel(application) {
	private val context = application
	val account = getUserAccountUseCase(getEmail())
	private fun getEmail(): String {
		val sharedPref = context.getSharedPreferences(
			SharedPref.PREFERENCE_FILE_KEY, Context.MODE_PRIVATE
		)
		return sharedPref.getString(SharedPref.EMAIL_USER_KEY, DEFAULT_VALUE_EMAIL)
			?: DEFAULT_VALUE_EMAIL
	}

	fun logout() {
		viewModelScope.launch(Dispatchers.IO) {
			account.value?.let {
				deleteUserAccountUseCase(it)
			}
		}
	}
}