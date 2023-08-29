package com.cos.jwt.config;

import com.cos.jwt.config.jwt.JwtAuthenticationFilter;
import com.cos.jwt.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// SecurityConfig 가 FilterConfig 보다 먼저 동작
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않겠다
                .and()
                .formLogin().disable() // 폼 로그인 사용 X
                /**
                 * HTTP Basic 인증은 사용자의 아이디와 패스워드를 요청 헤더에 담아 서버로 보내 인증하는 방식
                 * 패스워드가 평문으로 전송되어 안전하지 않은 방법
                 * HTTP Basic 인증을 비활성화
                 */
                .httpBasic().disable()
                .authorizeRequests(authorize ->
                    authorize
                            .antMatchers("/api/user/**").access("hasRole('ROLE_USER')")
                            .anyRequest().permitAll())
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
