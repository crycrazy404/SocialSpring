package service

import dto.UserDto

interface UserService {
    fun getAll(): List<UserDto>
    fun getByID(id: Long): UserDto
}