package com.example.demo.common.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException::class)
    private fun handleCustomException(e: CustomException): ResponseEntity<Any> {
        return ResponseEntity(
            Result(e.customExceptionCode.resultCode, e.customExceptionCode.resultMessage),
            e.customExceptionCode.status
        )
    }
}