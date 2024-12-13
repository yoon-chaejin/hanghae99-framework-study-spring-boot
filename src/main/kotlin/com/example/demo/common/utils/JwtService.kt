package com.example.demo.common.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class JwtService {

    private val SECRET_KEY = "secret"
    private val signingKey = Keys.hmacShaKeyFor(SECRET_KEY.toByteArray(StandardCharsets.UTF_8))

    fun generateToken(subject: String): String {
        val jwt = Jwts.builder().subject(subject).signWith(signingKey).compact()

        return "Bearer $jwt"
    }
}