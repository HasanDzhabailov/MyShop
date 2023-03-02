package com.example.myshop

import android.app.Application
import com.example.feature_home_screen.di.homeScreenModule
import com.example.feature_login_screen.di.loginScreenModule
import com.example.feature_product_details_screen.di.productDetailsScreenModule
import com.example.feature_profile_screen.di.profileScreenModule
import com.example.feature_sign_in_screen.di.signInScreenModule
import com.example.myshop.di.apiModule
import com.example.myshop.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
	override fun onCreate() {
		super.onCreate()
		startKoin{
			androidLogger(Level.DEBUG)
			androidContext(this@App)
			modules(
				listOf(
					apiModule,
					databaseModule,
					homeScreenModule,
					loginScreenModule,
					productDetailsScreenModule,
					signInScreenModule,
					profileScreenModule
				)
			)
		}
	}
}