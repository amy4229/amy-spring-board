package com.amy.springboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class PostComment extends AuditingMetaInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Post post;  // 게시글

    @Setter
    @Column(nullable = false, length=500)
    private String content; //본문

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
