package com.example.feature_sign_in_screen.presentation

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.example.core.common.BaseFragment
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_sign_in_screen.databinding.FragmentSignInBinding
import com.example.feature_sign_in_screen.domain.model.UsersAccount
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.core.R.string as coreString

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
	private val signInViewModel by viewModel<SignInViewModel>()
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		with(binding) {
			tvLogin.setOnClickListener {
				navigateToDeepLink(getString(coreString.login_screen), this@SignInFragment)
			}
			btnSignIn.setOnClickListener {
				var checkToastOneShow = 0
				if (checkValidityTextsInputs(inputFirstName, inputLastName, inputEmail)) {

					signInViewModel.checkAuthUser(inputEmail.text.toString())
					signInViewModel.isUserAuth.observe(viewLifecycleOwner) { checkAuth ->
						if (!checkAuth) {
							signInViewModel.signIn(
								UsersAccount(
									inputFirstName.text.toString(),
									inputLastName.text.toString(),
									inputEmail.text.toString()
								)
							)
							navigateToDeepLink(
								getString(coreString.profile_screen), this@SignInFragment
							)
						} else if (checkAuth && checkToastOneShow == 0) {
							 Toast.makeText(
							context,
							"Этот адрес электронной почты уже используется. Попробуйте другой.",
							Toast.LENGTH_LONG
						).show()
							checkToastOneShow = 1;
					}
					}

				}
			}
		}


	}

	private fun checkValidityTextsInputs(
		firstName: EditText,
		lastName: EditText,
		email: EditText,
	): Boolean {
		var checkValidate: Boolean =
			if (firstName.text.isBlank() || lastName.text.isBlank() || email.text.isBlank()) {
				Toast.makeText(context, "Заполните пустые поля!", Toast.LENGTH_LONG).show()
				false

			} else if (!Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
				Toast.makeText(context, "Неверно указан mail", Toast.LENGTH_LONG).show()
				false

			} else true
		return checkValidate
	}

}