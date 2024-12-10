package com.example.demo.domain.user

import com.example.demo.domain.user.request.SignUpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService,
) {

    @PostMapping("/signup")
    fun signup(@RequestBody user: SignUpRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(userService.signup(user))
    }
}