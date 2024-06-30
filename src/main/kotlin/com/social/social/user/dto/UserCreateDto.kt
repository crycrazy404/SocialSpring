package com.social.social.user.dto

data class UserCreateDto(
    val userName: String,
    val password: String,
    val firsName: String,
    val secondName: String,
    val email: String
)
