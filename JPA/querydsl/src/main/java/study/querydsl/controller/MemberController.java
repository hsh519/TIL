package study.querydsl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.repository.MemberJpaRepository;
import study.querydsl.repository.MemberRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

   private final MemberJpaRepository memberJpaRepository;
   private final MemberRepository memberRepository;

   @GetMapping("/v1/members")
    // 쿼리 파라미터로 condition에 바인딩 -> @ModelAttribute 생략
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
       return memberJpaRepository.search(condition);
   }

    @GetMapping("/v2/members")
    // 쿼리 파라미터로 page에 바인딩
    public Page<MemberTeamDto> searchMemberV1(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPageComplex(condition, pageable);
    }
}
