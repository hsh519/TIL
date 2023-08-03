package com.example.exhellojpa.repository;

import com.example.exhellojpa.entity.Member;

import java.util.List;

// 사용자 정의 레포지토리 구현. Querydsl 사용할 때 같이 사용
public interface MemberRepositoryCustom {

    List<Member> findMemberCustom();
}
