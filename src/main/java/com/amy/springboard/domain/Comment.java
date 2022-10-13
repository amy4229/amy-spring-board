package com.amy.springboard.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Post post;
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
