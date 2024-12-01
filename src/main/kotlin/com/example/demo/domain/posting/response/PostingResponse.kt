package com.example.demo.domain.posting.response

import com.example.demo.domain.posting.model.Posting
import java.time.LocalDateTime

data class PostingResponse (
    val id: Long,
    val title: String,
    val content: String,
    val writerName: String,
    val postedAt: LocalDateTime
)

fun Posting.toResponse() = PostingResponse(
    id = id!!,
    title = title,
    content = content,
    writerName = postedBy,
    postedAt = postedAt,
)