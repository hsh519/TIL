package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void 회원가입() {
        // given
        Member newMember = new Member(1L, "memberA", Grade.VIP);
        // when
        memberService.join(newMember);
        Member findMember = memberService.findMember(1L);
        // then
        Assertions.assertThat(newMember).isEqualTo(findMember);
    }
}
