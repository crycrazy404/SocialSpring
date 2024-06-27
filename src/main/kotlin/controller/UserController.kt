package controller

import dto.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.UserService

@RestController
@RequestMapping("/get")
class UserController (
        private val userService: UserService,
){
    @GetMapping("/all")
    fun getAll(): List<UserDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = userService.getByID(id)
}