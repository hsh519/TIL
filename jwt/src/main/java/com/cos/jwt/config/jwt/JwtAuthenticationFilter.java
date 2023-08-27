package com.cos.jwt.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cos.jwt.auth.PrincipalDetails;
import com.cos.jwt.model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있다
 * /login 요청해서 username, password 전송하면 (post)
 * UsernamePasswordAuthenticationFilter가 동작을 한다
 * 현재 SecurityConfig에서 폼로그인을 비활성화했기 때문에 동작을 안 한다
 * 그래서 SecurityConfig에 직접 UsernamePasswordAuthenticationFilter를 달아줘야 한다
 */

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해서 실행되는 메서드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도중");
        ObjectMapper objectMapper = new ObjectMapper();
        Member member = null;
        try {
            member = objectMapper.readValue(request.getInputStream(), Member.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("member = " + member);
        // username, password를 받아서 로그인 시도
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());

        /** authenticationManager로 로그인 시도를 하면 PrincipleDetailsService가 호출
         * PrincipleDetailsService가 호출되면 loadUserByUsername 메서드가 자동 실행
         * 정상이면 authentication이 리턴
         */
        Authentication authentication = authenticationManager.authenticate(token);

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principalDetails = " + principalDetails.getMember()); // 로그인이 정상 처리

        /**
         * PrincipleDetails를 세션에 담아 리턴
         * 세션에 담는 이유는 시큐리티가 대신 권한 관리 하기 위해서 (antMatchers())
         */
        return authentication;
    }

    /**
     * attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication 메서드 실행
     * 여기서 JWT 토큰을 만들어서 request 요청한 사용자에게 JWT 토큰을 response 해주면 된다
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("인증이 완료!!!");

        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
        String jwtToken = JWT.create()
                .withSubject("cos")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000*10))) // 만료 시간 => (현재 시간 + 만료 시간)
                .withClaim("id", principalDetails.getMember().getId())
                .withClaim("username", principalDetails.getMember().getUsername())
                .sign(Algorithm.HMAC512("cos"));

        response.addHeader("Authorization", "Bearer " + jwtToken);
    }
}
