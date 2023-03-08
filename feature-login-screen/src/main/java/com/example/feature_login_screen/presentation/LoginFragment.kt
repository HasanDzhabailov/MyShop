package com.example.feature_login_screen.presentation



import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.example.core.R.string as coreString
import com.example.core.common.BaseFragment
import com.example.core.database.saveAuthUser
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_login_screen.databinding.FragmentLoginBinding

import org.koin.androidx.viewmodel.ext.android.viewModel



class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
	private val loginViewModel by viewModel<LoginViewModel>()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		with(binding) {

			btnLogIn.setOnClickListener {
				val isValidate = checkValidityTextsInputs(inputFirstName, editPass)
				loginViewModel.loginIn(inputFirstName.text.toString(), editPass.text.toString())
				var checkLogin:Boolean = false
				loginViewModel.isLoginIn.observe(viewLifecycleOwner) { isLogin ->
					if(isLogin)	checkLogin =isLogin
					Log.d("ddd1",isLogin.toString())
					if (isValidate && checkLogin) {
						saveAuthUser(requireContext(),editPass.text.toString())
						navigateToDeepLink(getString(coreString.profile_screen), this@LoginFragment)
						checkLogin =false
					} else if(!checkLogin) Toast.makeText(context, "Неверно введен пароль/логин", Toast.LENGTH_LONG)
						.show()
				}

			}
		}
	}

	private fun checkValidityTextsInputs(
		firstName: EditText,
		password: EditText,
	): Boolean {
		var checkValidate: Boolean =
			if (firstName.text.isBlank() || password.text.isBlank()) {
				Toast.makeText(context, "Заполните пустые поля!", Toast.LENGTH_LONG).show()
				false
			} else true
		return checkValidate
	}

}