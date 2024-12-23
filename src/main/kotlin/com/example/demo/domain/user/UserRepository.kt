package com.example.demo.domain.user

import com.example.demo.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun existsUserByUsername(username: String): Boolean
    fun findByUsername(username: String): MutableList<User>
}