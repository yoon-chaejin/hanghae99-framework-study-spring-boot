package com.example.demo.domain.posting

import com.example.demo.domain.posting.request.CreatePostingRequest
import com.example.demo.domain.posting.request.DeletePostingRequest
import com.example.demo.domain.posting.request.ModifyPostingRequestWithPassword
import com.example.demo.domain.posting.response.PostingResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/postings")
class PostingController(
    val postingService: PostingService,
) {

    @GetMapping
    fun findAllPostings() : ResponseEntity<Any> {
        return ResponseEntity.ok(postingService.findAllPostings())
    }
    @GetMapping("{postingId}")
    fun findPostingById(@PathVariable("postingId") postingId: Long): ResponseEntity<PostingResponse> {
        return ResponseEntity.ok(postingService.findPostingById(postingId))
    }
    @PostMapping
    fun savePosting(@RequestBody posting: CreatePostingRequest): ResponseEntity<PostingResponse> {
        return ResponseEntity.ok(postingService.savePosting(posting))
    }
    @PutMapping("{postingId}")
    fun updatePosting(@PathVariable("postingId") postingId: Long, @RequestBody posting : ModifyPostingRequestWithPassword): ResponseEntity<PostingResponse> {
        return ResponseEntity.ok(postingService.verifyPasswordAndUpdatePosting(posting.password, postingId, posting.posting))
    }
    @DeleteMapping("{postingId}")
    fun deletePosting(@PathVariable("postingId") postingId: Long, @RequestBody request: DeletePostingRequest): ResponseEntity<Boolean> {
        return ResponseEntity.ok(postingService.verifyPasswordAndDeletePostingById(request.password, postingId))
    }
}