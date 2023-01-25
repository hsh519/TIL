package hello.core.autowired.allbean;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        // when
        int discountPrice1 = discountService.discount(member, 10000, "fixDiscountPolicy");
        int discountPrice2 = discountService.discount(member, 20000, "rateDiscountPolicy");
        //then
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice1).isEqualTo(1000);
        assertThat(discountPrice2).isEqualTo(2000);
    }

    @Component
    static class DiscountService {
        /*
        수동 빈 주입할 때는 설정 정보를 작성해 직접 주입했고, 자동 빈 주입할 때는 Autowired, Qualifier, Primary 어노테이션으로 제어를 했다.
        만약 사용자가 할인률을 정할 수 있다면? -> 어떤 할인률을 적용할지 모르기 때문에 할인률에 관련된 스프링 빈을 모두 주입해야 한다.
        해당 타입의 스프링 빈을 모두 사용해야 할 땐 Map, List 를 사용한다. 이후 생성자와 Autowired 어노테이션을 통해 해당 타입의 모든 빈을 주입받아야 한다.
         */

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap; // DiscountPolicy 이름, 구현 객체(=DiscountPolicy 타입 스프링 빈) 모두 주입
            this.policies = policies; // DiscountPolicy 구현 객체 모두 주입
            System.out.println("policyMap = " + policyMap); // FixDiscountPolicy, RateDiscountPolicy
            System.out.println("policies = " + policies); // FixDiscountPolicy, RateDiscountPolicy

        }

        public int discount(Member member, int price, String DiscountCode) {
            // 사용자가 적용한 할인률 -> DiscountCode
            // DiscountCode 를 키 값으로 해서 Map 에서 키에 해당하는 값의 할인 정책을 적용할 수 있다.
            DiscountPolicy discountPolicy = policyMap.get(DiscountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
