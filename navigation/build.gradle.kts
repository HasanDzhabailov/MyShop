plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

dependencies {
	//Module
	implementation(project(Modules.core))

	implementation(Kotlin.core)
	implementation(Design.appCompat)
	implementation(Design.material)
	//Navigation
	implementation(Navigation.navFragment)
	implementation(Navigation.navFragment)
	testImplementation(Tests.junit)
	androidTestImplementation(Tests.ext)
	androidTestImplementation(Tests.espresso)
}