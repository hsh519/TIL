package com.example.exhellojpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String username;
    private int age;

    public Member(String username) {
        this.username = username;
    }

    public static Member createMember(String username, int age) {
        Member member = new Member();
        member.setUsername(username);
        member.setAge(age);

        return member;
    }

    public static Member createMember(String username, int age, Team team) {
        Member member = new Member();
        member.setUsername(username);
        member.setAge(age);

        if (team != null) {
            member.changeTeam(team);
        }

        return member;
    }

    /* 연관관계 메서드 */
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
