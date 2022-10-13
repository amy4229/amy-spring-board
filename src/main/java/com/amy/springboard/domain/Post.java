package com.amy.springboard.domain;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String title;   // 제목
    private String content; // 본문
    private String tag;     //해시태그

    private LocalDateTime createdAt;    //최초등록일자
    private String createdBy;   // 최초등록자
    private LocalDateTime modifiedAt; // 최종수정일자
    private String modifiedBy;  //최종 수정자
}
