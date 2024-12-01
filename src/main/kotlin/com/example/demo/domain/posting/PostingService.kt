package com.example.demo.domain.posting

import com.example.demo.domain.posting.request.CreatePostingRequest
import com.example.demo.domain.posting.request.ModifyPostingRequest
import com.example.demo.domain.posting.response.PostingResponse
import org.springframework.stereotype.Service

@Service
interface PostingService {
    fun findAllPostings(): List<PostingResponse>

    fun findPostingById(id : Long): PostingResponse?

    fun savePosting(posting : CreatePostingRequest): PostingResponse

    fun verifyPasswordAndUpdatePosting(password: String, id: Long, posting : ModifyPostingRequest): PostingResponse?

    fun verifyPasswordAndDeletePostingById(password: String, id: Long): Boolean
}