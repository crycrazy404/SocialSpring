package com.social.social.service

import com.social.social.dto.UserDto

interface UserService {
    fun getAll(): List<UserDto>

    fun getById(id: Int): UserDto

    fun create(dto: UserDto): Int

    fun update(id: Int, dto: UserDto)

    fun delete(id: Int)
}