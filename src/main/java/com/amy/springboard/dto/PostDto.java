package com.amy.springboard.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.amy.springboard.domain.Post} entity
 */
public record PostDto(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String content,
        String tag
) implements Serializable {
    public static PostDto of(LocalDateTime createdAt,
                   String createdBy,
                   String title,
                   String content,
                   String tag) {
        return new PostDto(createdAt, createdBy, title, content, tag);
    }
}