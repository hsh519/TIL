package com.cos.security1.config;

import com.cos.security1.config.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(=SecurityConfig)가 스프링 필터체인에 등록이 됩니다.
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize, postAuthorize 어노테이션 활성화
@RequiredArgsConstructor
public class SecurityConfig {

    private final PrincipalOauth2UserService principalOauth2UserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 스프링 시큐리티 5.7.0부터 WebSecurityConfigurerAdapter 비권장
     * 대신 SecurityFilterChain Bean을 등록
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 비활성화

        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // /user 이하 -> 권한 O
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // /manager 이하 -> 권햔 O and (admin or manager) 역할 O
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // /manager 이하 -> 권햔 O and manager 역할 O
                .anyRequest().permitAll() // 나머지 주소는 권한 없어도 접근 가능
                /**
                 * 권한이 없는 상태에서 권한이 필요한 페이지 접근할 때 로그인 페이지로 이동할 수 있도록 합니다.
                 * 로그인 성공 시 -> 디폴트 페이지 X, 이전에 접근하려고 했던 페이지 O */
                .and()
                .formLogin()
                .loginPage("/login") // 이동할 로그인 페이지 지정
                /**
                 * 지정한 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행
                 * @PostMapping("login")이 필요 X
                 */
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/") // 로그인 성공시 이동할 디폴트 페이지 설정
                .and()
                .oauth2Login()
                .loginPage("/login") // oauth2.0 기반 로그인을 할 로그인 페이지 설정
                /**
                 * 일반적으로 oauth 2.0 기반 로그인이 완료된 뒤의 후처리가 필요
                 * 1. 코드 받기(인증)
                 * 2. 액세스 토큰(권한)
                 * 3. 사용자 프로필 정보 GET
                 * 4. 정보를 토대로 회원가입 자동 진행 or 필요한 정보 추가 입력을 받은 후 회원가입
                 *
                 * 구글의 경우 코드를 받지 않고 (액세스 토큰 + 사용자 프로필 정보) GET
                 */
                .userInfoEndpoint() // 인증 후 사용자 추가 정보를 가져오는 역할
                .userService(principalOauth2UserService); // 사용자 정보를 가져오는데 사용할 커스텀 서비스를 설정


        return http.build();
    }
}
