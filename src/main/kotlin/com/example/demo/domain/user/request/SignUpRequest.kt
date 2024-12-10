package com.example.demo.domain.user.request

import com.example.demo.domain.user.model.User

data class SignUpRequest(
    val username: String,
    val password: String
)

fun SignUpRequest.toEntity() = User (
    username = username,
    password = password,
)