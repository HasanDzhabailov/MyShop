package com.example.feature_profile_screen.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.example.core.common.BaseFragment
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_profile_screen.databinding.FragmentProfileBinding

import com.example.core.R.string as coreString


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
	override fun onAttach(context: Context) {
		super.onAttach(context)
		val callback = object : OnBackPressedCallback(
			true // default to enabled
		) {
			override fun handleOnBackPressed() {
				requireActivity().finish()
			}
		}
		requireActivity().onBackPressedDispatcher.addCallback(this, callback)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		with(binding) {
			llLogout.setOnClickListener {
				navigateToDeepLink(getString(coreString.sign_in_screen), this@ProfileFragment)


			}
		}
	}


}