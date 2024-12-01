package com.example.demo.domain.posting

import com.example.demo.domain.posting.model.Posting
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostingRepository : JpaRepository <Posting, Long>{
}