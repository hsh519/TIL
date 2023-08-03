package com.example.exhellojpa.controller;

import com.example.exhellojpa.dto.MemberDto;
import com.example.exhellojpa.entity.Member;
import com.example.exhellojpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    // 도메인 클래스 컨버터 (비추)
    @GetMapping("/members2/{id}")
    public String findMember(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    // page는 0부터 시작 주의
    // 엔티티를 넘기면 후에 엔티티 수정 시 API 스펙이 바뀌기 때문에 반드시 엔티티를 DTO로 변환해서 넘긴다.
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5) Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        return page.map(member -> new MemberDto(member));
    }

//    @PostConstruct
//    public void init() {
//        for (int i = 1; i <= 100; i++) {
//            memberRepository.save(Member.createMember("member" + i, i));
//        }
//    }
}
