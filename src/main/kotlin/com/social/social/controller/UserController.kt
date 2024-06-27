package com.social.social.controller

import com.social.social.dto.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.social.social.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/users")
class UserController (
    private val userService: UserService,
){
    @GetMapping("/all")
    fun getAll(): List<UserDto> =
        userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): UserDto =
        userService.getById(id)

    @PostMapping("/create")
    fun create(@RequestBody dto: UserDto): Int{
        return userService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int,
               @RequestBody dto: UserDto) {
        userService.update(id, dto)

    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int){
        userService.delete(id)
    }

}