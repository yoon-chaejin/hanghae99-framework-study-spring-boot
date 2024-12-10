package com.example.demo.domain.user

import com.example.demo.domain.user.model.User
import com.example.demo.domain.user.request.SignUpRequest
import com.example.demo.domain.user.request.toEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {
    override fun signup(user: SignUpRequest): User {
        return userRepository.save(user.toEntity())
    }
}