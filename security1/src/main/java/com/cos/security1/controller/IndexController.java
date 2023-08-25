package com.cos.security1.controller;

import com.cos.security1.config.PrincipalDetails;
import com.cos.security1.model.LoginForm;
import com.cos.security1.model.Member;
import com.cos.security1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    /**
     * Authentication -> 현재 인증된 사용자의 인증 정보와 권한을 가진 객체
     * getPrincipal() -> Authentication 객체에서 사용자의 주체 정보를 반환. 반환형이 Object이므로 UserDetails로 다운케스팅
     * UserDetails를 상속한 PrincipalDetails로도 당연히 다운캐스팅 가능
     * @AuthenticationPrincipal ->  Authentication + getPrincipal() 한 후 파라미터에 바인딩 해주는 어노테이션
     */
    @GetMapping("/test/login")
    @ResponseBody
    public String testLogin(Authentication authentication,
                            @AuthenticationPrincipal PrincipalDetails userDetails) {
        System.out.println("/test/login ==================== ");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("principalDetails = " + principalDetails.getMember());
        System.out.println("userDetails = " + userDetails.getMember());
        return "세션 정보 확인하기";
    }

    // 과정은 위와 동일하지만 차이점은 OAuth로 로그인할 경우 OAuth2User 타입으로 다운 캐스팅
    @GetMapping("/test/oauth/login")
    @ResponseBody
    public String testOauthLogin(@AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println("/test/oauth/login ==================== ");
        System.out.println("oAuth2User = " + oAuth2User.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails = " + principalDetails.getMember());
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    /**
     * 이 경우 스프링 시큐리티가 로그인을 빼앗아 간다.
     * SecurityConfig 파일 설정 -> 더 이상 빼앗아가지 않는다.
     */
    @GetMapping("/login")
    public String loginForm(Model model, HttpSession session) {
        // session으로 회원정보 가져오기. 있으면 이미 로그인 했으므로 홈화면, 없으면 로그인 화면
        if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
            return "redirect:/";
        }
        model.addAttribute("loginForm", new LoginForm());
        return "loginForm";
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new Member());
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(Member member) {
        if (member.getUsername().equals("admin")) { member.setRole("ROLE_ADMIN"); }
        else if (member.getUsername().equals("manager")) { member.setRole("ROLE_MANAGER"); }
        else { member.setRole("ROLE_USER"); }

        // 스프링 시큐리티를 사용할 땐 반드시 비밀번호 암호화 후 저장. 그렇지 않으면 시큐리티 로그인 X
        String password = member.getPassword();
        String encPassword = passwordEncoder.encode(password);
        member.setPassword(encPassword);

        memberRepository.save(member);
        return "redirect:/login";
    }

    @Secured("ROLE_ADMIN") // 권한처리를 간단하게 할 수 있는 어노테이션. 하나의 권한만 처리할 때 사용
    @ResponseBody
    @GetMapping("/info")
    public String info() {
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // data 메서드가 실행되기 직전에 실행. 여러 개의 권한을 처리할 때 사용
    @ResponseBody
    @GetMapping("/data")
    public String data() {
        return "데이터정보";
    }
}
