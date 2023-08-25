package com.cos.security1.config.oauth.provider;

/**
 * OAuth 로그인마다 attributes 키가 다르기 떄문에 인터페이스와 구현 객체로 처리
 * 구글 providerId 키 -> sub, 페이스북 providerId 키 -> id
 * 따라서 구글 구현 객체에서는 getAttribute("sub")로, 페이스북 구현 객체에서는 getAttribute("id")로 getProviderId() 메서드를 구성
 */
public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();
}
