package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// JUnit5 부터는 public 없어도 된다
class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 저장() {
        //given
        Member member = new Member("hello", 20);
        // when
        Member saveMember = memberRepository.save(member);
        // then
        assertThat(saveMember).isEqualTo(memberRepository.findById(member.getId()));
    }

    @Test
    void 모든회원조회() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> res = memberRepository.findAll();

        // then
        assertThat(res.size()).isEqualTo(2);
        assertThat(res).contains(member1, member2); // member1, member2가 res에 포함되어 있나
    }
}
