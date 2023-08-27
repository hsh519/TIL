package com.cos.jwt.config;

import com.cos.jwt.config.jwt.JwtAuthenticationFilter;
import com.cos.jwt.config.jwt.JwtAuthorizationFilter;
import com.cos.jwt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// SecurityConfig가 FilterConfig보다 먼저 동작
public class SecurityConfig {

    private final CorsConfig corsConfig;
    private final MemberRepository memberRepository;

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
                .apply(new MyCustomDsl())
                .and()
                .authorizeRequests(authorize ->
                    authorize
                            .antMatchers("/api/v1/user/**")
                            .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                            .antMatchers("/api/v1/manager/**")
                            .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                            .antMatchers("/api/v1/admin/**")
                            .access("hasRole('ROLE_ADMIN')")
                            .anyRequest().permitAll())
                .build();
    }

    /**
     * AuthenticationManager 파라미터를 필수로 넘겨야 한다
     * 로그인을 진행하는 필터인 JwtAuthenticationFilter
     * 따라서 로그인을 진행하는 메니저인 AuthenticationManager를 파라미터로 넘겨야 한다
     */
    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http
                    .addFilter(corsConfig.corsFilter())
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository));
        }
    }
}
