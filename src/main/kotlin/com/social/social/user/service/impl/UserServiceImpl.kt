package com.social.social.user.service.impl

import com.social.social.user.dto.UserDto
import com.social.social.user.dto.UserUpdateDto
import com.social.social.user.entity.UserEntity
import com.social.social.user.repository.UserRepository
import org.springframework.stereotype.Service
import com.social.social.user.service.UserService
import org.springframework.data.repository.findByIdOrNull

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun getAll(): List<UserDto> {
        return userRepository.findAll().map {
            it.toDto()
        }

    }

    override fun getById(id: Int): UserDto {
        return userRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw RuntimeException("User not found")
    }

    override fun create(dto: UserDto): UserDto {
        return userRepository.save(dto.toEntity()).toDto()
    }

    override fun update(id: Int, dto: UserUpdateDto): UserDto {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User not found")

        existingUser.name = dto.name
        existingUser.email = dto.email

        return userRepository.save(existingUser).toDto()
    }

    override fun delete(id: Int) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User not found")

        userRepository.deleteById(existingUser.id)
    }

    private fun UserEntity.toDto(): UserDto =
        UserDto(
            id = this.id,
            name = this.name,
            email = this.email,
        )

    private fun UserDto.toEntity(): UserEntity =
        UserEntity(
            id = 0,
            name = this.name,
            email = this.email,
        )
}