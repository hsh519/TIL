package com.cos.security1.config;

import com.cos.security1.model.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 시큐리티가 /login 주소 요청을 낚아채서 로그인을 진행
 * 로그인 진행이 완료되면 시큐리티 세션을 생성
 * 키와 값으로 구성되며 키는 Security ContextHolder
 * 세션에 저장할 수 있는 오브젝트 -> Authentication 타입 객체
 * Authentication 안에 회원 정보가 있어야 합니다
 * 회원 정보의 타입 -> UserDetails 타입 객체
 */

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private final Member member;
    private Map<String, Object> attributes;

    // 일반 로그인 생성자
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    // OAuth 로그인 생성자
    public PrincipalDetails(Member member, Map<String, Object> attributes) {
        this.member = member;
        this.attributes = attributes;
    }

    // 해당 회원의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(member::getRole);
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    // 사용자 계정이 만료되지 않았는지 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 회원이 잠기지 않았는지 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 사용자 인증 정보가 만료되지 않았는지 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }
}
