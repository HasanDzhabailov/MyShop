package com.example.feature_sign_in_screen.presentation

import android.os.Bundle
import android.view.View

import com.example.core.common.BaseFragment
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_sign_in_screen.databinding.FragmentSignInBinding
import com.example.core.R.string as coreString

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		with(binding){
			tvLogin.setOnClickListener{
				navigateToDeepLink(getString(coreString.login_screen),this@SignInFragment)
			}
			btnSignIn.setOnClickListener {
				navigateToDeepLink(getString(coreString.home_screen),this@SignInFragment)
			}
		}


	}

}