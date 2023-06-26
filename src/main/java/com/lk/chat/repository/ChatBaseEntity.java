package com.lk.chat.repository;


import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class ChatBaseEntity {

    @Comment("등록유저ID")
    @CreatedBy
    @Column(nullable = false, updatable = false, length = 10)
    private String regUserId;

    @Comment("등록일시")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp regTs;

    @Comment("수정유저ID")
    @LastModifiedBy
    @Column(nullable = false, updatable = false, length = 10)
    private String modUserId;

    @Comment("수정일시")
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private Timestamp modTs;

}
