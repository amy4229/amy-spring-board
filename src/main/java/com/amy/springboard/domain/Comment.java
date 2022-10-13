package com.amy.springboard.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Post post;  // 게시글
    private String content; //본문

    private LocalDateTime createdAt;    //최초등록일자
    private String createdBy;   // 최초등록자
    private LocalDateTime modifiedAt; // 최종수정일자
    private String modifiedBy;  //최종 수정자
}
