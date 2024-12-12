package com.example.demo.common.response

import com.example.demo.common.exception.Result

data class ResponseWithResultAndBody (
    val result: Result = Result("0000", "success"),
    val body: Any
)