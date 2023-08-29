package com.cos.jwt.service;

import com.cos.jwt.config.jwt.JwtTokenProvider;
import com.cos.jwt.config.jwt.TokenInfo;
import com.cos.jwt.config.token.RefreshToken;
import com.cos.jwt.model.Member;
import com.cos.jwt.repository.MemberRepository;
import com.cos.jwt.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void join(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
    }

    @Transactional
    public TokenInfo login(String memberId, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Transactional
    public TokenInfo generateRefreshToken(String refreshToken, Authentication authentication) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findById(refreshToken);
        System.out.println("optionalRefreshToken = " + optionalRefreshToken);
        if (optionalRefreshToken.isPresent()) {
            return jwtTokenProvider.generateToken(authentication);
        }
        return null;
    }
}
