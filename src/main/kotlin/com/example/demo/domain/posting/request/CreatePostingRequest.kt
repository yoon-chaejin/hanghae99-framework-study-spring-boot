package com.example.demo.domain.posting.request

import com.example.demo.domain.posting.model.Posting
import java.time.LocalDateTime

data class CreatePostingRequest (
    val title: String,
    val content: String,
    val password: String,
    val writerName: String,
)

fun CreatePostingRequest.toEntity() = Posting (
    title = title,
    content = content,
    password = password,
    postedBy = writerName,
    postedAt = LocalDateTime.now()
)