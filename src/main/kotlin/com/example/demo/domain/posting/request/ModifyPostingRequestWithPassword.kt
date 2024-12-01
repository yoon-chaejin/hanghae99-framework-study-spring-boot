package com.example.demo.domain.posting.request

data class ModifyPostingRequestWithPassword (
    val password: String,
    val posting: ModifyPostingRequest,
)