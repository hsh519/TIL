package com.cos.jwt.controller;

import com.cos.jwt.auth.PrincipalDetails;
import com.cos.jwt.config.jwt.TokenInfo;
import com.cos.jwt.model.Member;
import com.cos.jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final MemberService memberService;

    @GetMapping("home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("token")
    public String token() {
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody Member member) {
        memberService.join(member);
        return "회원가입 완료";
    }

    @PostMapping("login")
    public TokenInfo login(@RequestBody Member member) {
        String memberId = member.getUsername();
        String password = member.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }

    @GetMapping("/api/user")
    public String user() {
         return "user";
    }

    @PostMapping("refreshToken")
    public TokenInfo refreshToken(HttpServletRequest request, Authentication authentication) {
        String refreshToken = request.getHeader("refreshToken");
        System.out.println("refreshToken = " + refreshToken);
        TokenInfo tokenInfo = memberService.generateRefreshToken(refreshToken, authentication);
        System.out.println("tokenInfo = " + tokenInfo.toString());
        return tokenInfo;
    }

}
