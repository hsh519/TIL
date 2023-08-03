package com.example.exhellojpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {

    // 오픈 프로젝션. 엔티티를 싹 가져와서 필요한 데이터를 처리
    // @Value 가 없으면 클로스 프로젝션. 정확히 한 데이터만 처리
    @Value("#{target.username + ' ' + target.age}")
    String getUsername();
}
