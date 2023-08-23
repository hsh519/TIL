package com.cos.security1.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString(of = {"id", "username", "email", "role", "createDate"})
@EntityListeners(AuditingEntityListener.class) // @CreateDate 사용 시 필수 어노테이션
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role; // ROLE_USER, ROLE_MANAGER, ROLE_ADMIN

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

}
