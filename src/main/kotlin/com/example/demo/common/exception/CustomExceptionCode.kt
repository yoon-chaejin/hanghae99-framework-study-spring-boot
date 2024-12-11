package com.example.demo.common.exception

import org.springframework.http.HttpStatus

enum class CustomExceptionCode (val status: HttpStatus, val resultCode: String, val resultMessage: String) {
    DUPLICATE_USER(HttpStatus.BAD_REQUEST, "1001", "Duplicate User"),
}