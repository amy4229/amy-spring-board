package com.amy.springboard.repository;

import com.amy.springboard.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}