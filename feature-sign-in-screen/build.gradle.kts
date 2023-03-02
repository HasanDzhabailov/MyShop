plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

dependencies {

	implementation(Kotlin.core)
	implementation(Design.appCompat)
	implementation(Design.material)
	//  Koin
	implementation(Koin.koinCore)
	implementation(Koin.koinAndroid)
	testImplementation(Tests.junit)
	androidTestImplementation(Tests.ext)
	androidTestImplementation(Tests.espresso)
}