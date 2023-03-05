plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}


dependencies {

	implementation(Kotlin.core)
	implementation(Design.appCompat)
	implementation(Design.material)
	//Navigation
	implementation(Navigation.navFragment)
	implementation(Navigation.navFragment)
	//Fragment
	implementation(FragmentKtxLibrary.fragmentKtxLibrary)
	//Test
	testImplementation(Tests.junit)
	androidTestImplementation(Tests.ext)
	androidTestImplementation(Tests.espresso)
}