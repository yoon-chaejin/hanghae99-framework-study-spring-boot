package com.example.demo.domain.user.request

import com.example.demo.domain.user.model.User
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignUpRequest(

    @field:Size(min = 4, max = 8)
    @field:Pattern(regexp = "[0-9a-z]+")
    val username: String,

    @field:Size(min = 8, max = 15)
    @field:Pattern(regexp = "[0-9a-zA-Z]+")
    val password: String
)

fun SignUpRequest.toEntity() = User (
    username = username,
    password = password,
)