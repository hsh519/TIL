package com.example.exhellojpa.repository;

// 중첩 구조(조인이 들어가는 순간)는 클로즈 프로젝션이라도 다음 엔티티는 최적화 X
public interface NestedClosedProjections {

    String getUsername();
    TeamInfo getTeam();

    interface  TeamInfo {
        String getName();
    }
}
