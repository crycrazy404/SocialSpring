package service.impl

import dto.UserDto
import org.springframework.stereotype.Service
import service.UserService

@Service
class UserServiceImpl : UserService {
    override fun getAll(): List<UserDto> {
        return listOf(
                UserDto(1, "test", "test"),
                UserDto(2, "test2", "test2"),
                UserDto(3, "test3", "test3"),
        )
    }

    override fun getByID(id: Long): UserDto {
        val a: List<UserDto> = listOf(
            UserDto(1, "test", "test"),
            UserDto(2, "test2", "test2"),
            UserDto(3, "test3", "test3"),)
        return a[id.toInt()]
    }
}