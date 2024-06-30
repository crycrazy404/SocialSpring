package com.social.social.user.dto

data class UserUpdateDto(
    val userName: String,
    val password: String,
    val firsName: String,
    val secondName: String,
    val bigPicture: String,
    val medPicture: String,
    val smPicture: String,
    val email: String
)