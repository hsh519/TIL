package com.cos.security1.config;

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
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoderPwd() {
        return new BCryptPasswordEncoder();
    }

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
                .defaultSuccessUrl("/"); // 로그인 성공시 이동할 디폴트 페이지 설정

        return http.build();
    }
}
