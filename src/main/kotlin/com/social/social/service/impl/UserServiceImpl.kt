package com.social.social.service.impl

import com.social.social.dto.UserDto
import com.social.social.entity.UserEntity
import com.social.social.repository.UserRepository
import org.springframework.stereotype.Service
import com.social.social.service.UserService
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

    override fun create(dto: UserDto): Int {
        return userRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: UserDto) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw RuntimeException("User not found")

        existingUser.name = dto.name
        existingUser.email = dto.email

        userRepository.save(existingUser)
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