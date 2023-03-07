package com.example.feature_sign_in_screen.data.mapper

import com.example.core.database.UserAccountDB
import com.example.feature_sign_in_screen.domain.model.UsersAccount


data class UserAccountDto(
	val firstName:String,
	val lastName:String,
	val email:String
){

}

fun UserAccountDto.toUserAccount(): UsersAccount {
	val userAccountDB = UserAccountDB(firstName = firstName, lastName = lastName, email = email)
	return UsersAccount(firstName = firstName, lastName = lastName, email = email)
}

