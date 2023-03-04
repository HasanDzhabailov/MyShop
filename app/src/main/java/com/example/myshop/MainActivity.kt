package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
	private val binding: ActivityMainBinding by lazy {
		ActivityMainBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		binding.bottomNavigationView.setOnItemSelectedListener { item ->
			when (item.itemId) {
				com.example.navigation.R.id.home_screen -> {
					return@setOnItemSelectedListener true
				}
				com.example.feature_profile_screen.R.id.profile_screen ->{
					return@setOnItemSelectedListener true
				}
			}
			false
		}
		setupNav()
	}

	private fun setupNav() {
		val navHostFragment =
			supportFragmentManager.findFragmentById(R.id.main_nav_graph) as NavHostFragment
		val navController = navHostFragment.navController

		navController.addOnDestinationChangedListener { _, destination, _ ->

			when (destination.id) {
				com.example.navigation.R.id.home_screen - 1 -> showBottomNav()
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