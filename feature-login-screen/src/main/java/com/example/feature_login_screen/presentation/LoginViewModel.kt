package com.example.feature_login_screen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_login_screen.domain.use_case.LoginInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val loginInUseCase: LoginInUseCase):ViewModel() {
	private var _isLoginIn = MutableLiveData<Boolean>()
	val isLoginIn: MutableLiveData<Boolean> = _isLoginIn

	fun loginIn(firstName:String, password:String){
		viewModelScope.launch(Dispatchers.Main){
			_isLoginIn.postValue(loginInUseCase(firstName,password)!!)
		}
	}
}