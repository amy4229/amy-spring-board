package com.amy.springboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Post post;  // 게시글

    @Setter
    @Column(nullable = false, length=500)
    private String content; //본문

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;    //최초등록일자
    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy;   // 최초등록자
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 최종수정일자
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;  //최종 수정자

    protected PostComment() {}

    private PostComment(Post post, String content) {
        this.post = post;
        this.content = content;
    }

    public static PostComment of(Post post, String content){
        return new PostComment(post, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment PostComment)) return false;
        return id != null && id.equals(PostComment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
