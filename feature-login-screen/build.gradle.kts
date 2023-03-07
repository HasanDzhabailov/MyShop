plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id ("kotlin-kapt")
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
	//Fragment
	implementation(FragmentKtxLibrary.fragmentKtxLibrary)
	//Room
	implementation(Room.roomRuntime)
	kapt(Room.kaptRoomCompiler)
	implementation (Room.roomKtx)
	//Test
	testImplementation(Tests.junit)
	androidTestImplementation(Tests.ext)
	androidTestImplementation(Tests.espresso)
}