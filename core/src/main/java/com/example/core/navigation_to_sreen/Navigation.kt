package com.example.core.navigation_to_sreen

import android.R
import android.app.Activity
import android.util.Log
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController


fun navigateToDeepLink(deepLink: String, fragment: Fragment) {
	val request = NavDeepLinkRequest.Builder
		.fromUri(deepLink.toUri())
		.build()
	findNavController(fragment).navigate(request)
}

fun navigateBottomToDeepLink(deepLink: String, activity: Activity,view:Int) {

	val request = NavDeepLinkRequest.Builder
		.fromUri(deepLink.toUri())
		.build()
	Navigation.findNavController(activity, view).navigate(request)
}

