package com.example.feature_login_screen.presentation


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.R.string as coreString
import com.example.core.common.BaseFragment
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_login_screen.R
import com.example.feature_login_screen.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		with(binding){
			btnLogIn.setOnClickListener{
				navigateToDeepLink(getString(coreString.home_screen),this@LoginFragment)
			}
		}
	}
}