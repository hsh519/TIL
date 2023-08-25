package com.cos.security1.config.auth;

import com.cos.security1.config.PrincipalDetails;
import com.cos.security1.model.Member;
import com.cos.security1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * SecurityConfig 파일에서 loginProcessingUrl("/login");
 * login 요청이 오면 자동으로 UserDetailsService 구현 객체의 loadUserByUsername 메서드 실행
 */
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    /**
     * username 파라미터는 로그인 시도할 때 작성한 username. 로그인 관련 html 파일에서 name 속성을 반드시 username으로 설정
     * UserDetails 구현 객체를 리턴
     */
    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        Optional<Member> optionalMember = memberRepository.findByUsername(username);
        return optionalMember.map(PrincipalDetails::new).orElse(null);
    }
}
