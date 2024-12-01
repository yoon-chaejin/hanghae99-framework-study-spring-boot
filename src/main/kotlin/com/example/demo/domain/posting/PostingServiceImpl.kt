package com.example.demo.domain.posting

import com.example.demo.domain.posting.request.CreatePostingRequest
import com.example.demo.domain.posting.request.ModifyPostingRequest
import com.example.demo.domain.posting.request.toEntity
import com.example.demo.domain.posting.response.PostingResponse
import com.example.demo.domain.posting.response.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostingServiceImpl (
    val postingRepository: PostingRepository,
) : PostingService {
    override fun findAllPostings(): List<PostingResponse> {
        return postingRepository.findAll().map{ it.toResponse() }
    }

    override fun findPostingById(id: Long): PostingResponse? {
        return postingRepository.findByIdOrNull(id)?.toResponse()
    }

    override fun savePosting(posting: CreatePostingRequest): PostingResponse {
        return postingRepository.save(posting.toEntity()).toResponse()
    }

    override fun verifyPasswordAndUpdatePosting(password: String, id: Long, posting: ModifyPostingRequest): PostingResponse? {
        return if (isVerified(password, id)) {
            postingRepository.save(posting.toEntity(id, password)).toResponse()
        } else {
            null
        }
    }

    override fun verifyPasswordAndDeletePostingById(password: String, id: Long): Boolean {
        return if (isVerified(password, id)) {
            postingRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    private fun isVerified(password: String, id: Long): Boolean {
        val posting = postingRepository.findByIdOrNull(id)
        return password == posting?.password
    }

}