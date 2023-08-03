package com.example.exhellojpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    @PrePersist // persist 이전에 실행
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        lastModifiedDate = now;
    }

    @PreUpdate // update 이전에 실행
    public void preUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
