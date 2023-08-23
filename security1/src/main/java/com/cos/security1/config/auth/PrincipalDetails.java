package com.cos.security1.config.auth;

import com.cos.security1.model.Member;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 시큐리티가 /login 주소 요청을 낚아채서 로그인을 진행
 * 로그인 진행이 완료되면 시큐리티 세션을 생성
 * 키와 값으로 구성되며 키는 Security ContextHolder
 * 세션에 저장할 수 있는 오브젝트 -> Authentication 타입 객체
 * Authentication 안에 회원 정보가 있어야 합니다
 * 회원 정보의 타입 -> UserDetails 타입 객체
 */

@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {

    private final Member member;

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
}
