plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

dependencies {
	//module
	implementation(project(Modules.core))

	implementation(Kotlin.core)
	implementation(Design.appCompat)
	implementation(Design.material)
	//  Koin
	implementation(Koin.koinCore)
	implementation(Koin.koinAndroid)
	//Navigation
	implementation(Navigation.navFragment)
	implementation(Navigation.navFragment)
	//Retrofit
	implementation(Retrofit.retrofit)
	implementation(Retrofit.converterGson)
	implementation(Retrofit.gson)
	// Glide
	implementation(Glide.glide)
	implementation(Glide.glideCompiler)
	//Test
	testImplementation(Tests.junit)
	androidTestImplementation(Tests.ext)
	androidTestImplementation(Tests.espresso)
}