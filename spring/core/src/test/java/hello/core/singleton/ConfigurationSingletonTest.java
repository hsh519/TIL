package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 자바 코드로만 보면 memberService 호출, orderService 호출, memberRepository 호출 할때 new MemoryMemberRepository 가 리턴되어 세 객체의 memberRepository 가 달라야 한다
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        MemberRepository memberRepository1 = orderService.getMemberRepository();
        MemberRepository memberRepository2 = memberService.getMemberRepository();
        // 확인결과 모두 동일 -> 즉 객체 하나만 생성
        System.out.println(memberRepository1);
        System.out.println(memberRepository2);
        System.out.println(memberRepository);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
        Assertions.assertThat(memberRepository2).isSameAs(memberRepository);
        Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig 를 넘기면 AppConfig 또한 빈으로 생성된다.
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println(bean.getClass());
    }
}
