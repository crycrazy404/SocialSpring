package com.social.social.user.dto

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date

data class UserDto(
        val id: Int? = null,
        val userName: String,
        val password: String,
        val firsName: String,
        val secondName: String,
        val bigPicture: String,
        val medPicture: String,
        val smPicture: String,
        val regDate: LocalDateTime,
        val email: String
)

