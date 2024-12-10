package com.example.demo.domain.user.request

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class SignUpRequestTest {

    private val validator: Validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun validTest_GivenValidUsernameAndValidPassword_ReturnsTrue() {
        //given
        val sut = SignUpRequest("abcd", "abcd1234")

        //when
        val result = validator.validate(sut)

        //then
        assertTrue(result.isEmpty())
    }

    @Test
    fun validTest_GivenInvalidUsername_ReturnsFalse() {
        //given
        val sut = SignUpRequest("abc", "abcd1234")

        //when
        val result = validator.validate(sut)

        //then
        assertFalse(result.isEmpty())
    }

    @Test
    fun validTest_GivenInvalidPassword_ReturnsFalse() {
        //given
        val sut = SignUpRequest("abcd", "abcd123")

        //when
        val result = validator.validate(sut)

        //then
        assertFalse(result.isEmpty())
    }
}