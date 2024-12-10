package com.example.demo.domain.user

import com.example.demo.domain.user.model.User
import com.example.demo.domain.user.request.SignUpRequest
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun signup(user : SignUpRequest): User
}