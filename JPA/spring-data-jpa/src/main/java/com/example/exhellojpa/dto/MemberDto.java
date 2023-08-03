package com.example.exhellojpa.dto;

import com.example.exhellojpa.entity.Member;
import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    // DTO는 엔티티를 봐도 된다. 반대는 절대 불가
    public MemberDto(Member member) {
        id = member.getId();
        username = member.getUsername();
        teamName = null;
    }
}
