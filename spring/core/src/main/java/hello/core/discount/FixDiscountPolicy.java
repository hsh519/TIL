package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
수동으로 빈을 등록하면 구현 객체를 정해서 의존 관계를 주입하기 때문에 getBean(타입) 으로 스프링 빈을 조회했을 때 오류가 거의 발생하지 않는다
자동으로 빈을 등록하면 스프링 빈중 동일한 타입이 존재할 수 있기 때문에 getBean(타입) 으로 스프링 빈을 조회하면 오류가 발생할 수 있다
이 문제를 해결하기 위해 @Autowired, @Qualifier, @Primary 어노테이션이 있다
@Autowired - 해당 타입으로 찾고, 결과가 2개 이상이면 파라미터명, 필드 명에 타입 이름이 포함된 스프링 빈을 찾는다
@Qualifier("별명") - 해당 별명을 가진 스프링 빈을 찾는다.
@Primary - 이 어노테이션을 가진 스프링 빈이 우선 순위를 가진다.

@Qualifier 와 @Primary 가 동시에 있을 경우 @Qualifier 을 따른다
*/
@Component
//@Qualifier("fixDiscountPolicy") Qualifier 어노테이션 사용법
@Primary
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    /* 얼마만큼 할인되는지가 리턴값 */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
