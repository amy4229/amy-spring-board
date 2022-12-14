package com.amy.springboard.domain;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Table( indexes = {
        @Index(columnList = "userId"),
        @Index(columnList = "email", unique=true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
        })
@Entity
public class UserAccount extends AuditingMetaInfo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false, length = 50) private String userId;
    @Setter @Column(nullable = false) private String userPassword;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickname;
    @Setter private String memo;

    protected UserAccount(){}

    private UserAccount(Long id, String userId, String userPassword, String email, String nickname, String memo) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
    }

    public UserAccount of (Long id, String userId, String userPassword, String email, String nickname, String memo){
        return new UserAccount(id,userId,userPassword,email,nickname,memo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
