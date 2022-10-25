package com.amy.springboard.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditingMetaInfo {

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;    //최초등록일자
    @CreatedBy
    @Column(nullable = false, length = 100, updatable = false)
    private String createdBy;   // 최초등록자
    @LastModifiedDate
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime modifiedAt; // 최종수정일자
    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;  //최종 수정자

}
