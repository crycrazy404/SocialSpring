package com.social.social.user.service

import com.social.social.user.dto.UserDto
import com.social.social.user.dto.UserUpdateDto

interface UserService {
    fun getAll(): List<UserDto>

    fun getById(id: Int): UserDto

    fun create(dto: UserDto): UserDto

    fun update(id: Int, dto: UserUpdateDto): UserDto

    fun delete(id: Int)
}