package com.example.demo.domain.posting.request

import com.example.demo.domain.posting.model.Posting
import java.time.LocalDateTime

data class ModifyPostingRequest (
    val title: String,
    val content: String,
    val writerName: String,
)

fun ModifyPostingRequest.toEntity(id: Long, password: String) = Posting (
    id = id,
    title = title,
    content = content,
    password = password,
    postedBy = writerName,
    postedAt = LocalDateTime.now(),
)