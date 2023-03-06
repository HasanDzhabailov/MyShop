package com.example.feature_sign_in_screen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_sign_in_screen.domain.model.UsersAccount
import com.example.feature_sign_in_screen.domain.use_case.CheckAuthUserUseCase
import com.example.feature_sign_in_screen.domain.use_case.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
	private val signInUseCase: SignInUseCase,
	private val checkAuthUserUseCase: CheckAuthUserUseCase,
) : ViewModel() {
	private var _isUserAuth = MutableLiveData<Boolean>()
	val isUserAuth: MutableLiveData<Boolean> = _isUserAuth
	fun signIn(usersAccount: UsersAccount) {
		viewModelScope.launch(Dispatchers.IO) {
			signInUseCase(usersAccount)
		}
	}

	fun checkAuthUser(email: String) {
		viewModelScope.launch(Dispatchers.Main ) {
		_isUserAuth.value =	checkAuthUserUseCase(email)!!
		}

	}



}