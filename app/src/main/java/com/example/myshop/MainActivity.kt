package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.example.core.navigation_to_sreen.navigateBottomToDeepLink

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.example.navigation.R.id as navModule

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
		bottomNav.selectedItemId = navModule.profile_screen
		bottomNav.setOnItemSelectedListener(
			NavigationBarView.OnItemSelectedListener {

				when (it.itemId) {
					navModule.profile_screen -> {
						navigateBottomToDeepLink(
							getString(com.example.core.R.string.profile_screen),
							this,
							R.id.main_nav_graph
						)
						return@OnItemSelectedListener true
					}

					navModule.home_screen -> {
						navigateBottomToDeepLink(
							getString(com.example.core.R.string.home_screen),
							this,
							R.id.main_nav_graph
						)
						return@OnItemSelectedListener true
					}

				}
				false
			})

		setupNav()
	}

	private fun setupNav() {
		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.main_nav_graph) as NavHostFragment
		val navController = navHostFragment.navController
		navController.addOnDestinationChangedListener { _, destination, _ ->

			when (destination.id) {
				com.example.navigation.R.id.home_screen - 1 -> {
					showBottomNav()
				}
				com.example.navigation.R.id.profile_screen - 1 -> showBottomNav()
				com.example.navigation.R.id.product_details_screen - 1 -> showBottomNav()
				else -> hideBottomNav()
			}
		}


	}

	private fun showBottomNav() {
		findViewById<BottomNavigationView>(R.id.bottom_navigation_view).visibility = View.VISIBLE
	}

	private fun hideBottomNav() {
		findViewById<BottomNavigationView>(R.id.bottom_navigation_view).visibility = View.GONE
	}

}