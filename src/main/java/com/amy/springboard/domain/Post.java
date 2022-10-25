package com.amy.springboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "tag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class Post extends AuditingMetaInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 255)
    private String title;   // 제목
    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 본문
    @Setter
    private String tag;     //해시태그

    @OrderBy("id")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<PostComment> postComments = new LinkedHashSet<>();

    protected Post(){}

    private Post(String title, String content, String tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

    public static Post of(String title, String content, String tag) {
        return new Post(title, content, tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return id != null && id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
