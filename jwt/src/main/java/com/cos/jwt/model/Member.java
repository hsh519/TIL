package com.cos.jwt.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString(of = {"id", "username", "roles"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    private String username;
    private String password;
    private String roles;

    public List<String> getRoleList() {
        return (roles.length() > 0) ? Arrays.asList(roles.split(",")) : null;
    }
}
