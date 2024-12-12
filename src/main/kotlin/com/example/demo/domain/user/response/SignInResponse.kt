package com.example.demo.domain.user.response

import com.example.demo.domain.user.model.User

data class SignInResponse(
    val id: Long,
    val username: String,
)
fun User.toResponse() = SignInResponse (
    id = this.id!!,
    username = this.username,
)