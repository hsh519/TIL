package com.cos.security1.controller;

import com.cos.security1.model.LoginForm;
import com.cos.security1.model.Member;
import com.cos.security1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // SecurityContextHolder으로 회원정보 가져오기
        log.info("name = {}", authentication.getName()); // 로그인한 회원 이름
        log.info("isAuthentication = {}", authentication.isAuthenticated()); // 인증 여부

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
