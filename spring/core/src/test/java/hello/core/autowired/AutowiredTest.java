package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {
    
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // Member 클래스는 스프링 빈 X
    @Component
    static class TestBean {
        // 주입할 스프링 빈이 없을 때 3가지 처리
        // required = false -> 주입할 스프링 빈이 없으면 메서드 자체가 호출이 안된다
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        // @Nullable -> 메서드는 호출되지만 주입할 스프링 빈이 없다면 null 이 입력된다
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }
        // Optional<> -> 메서드 호출되며 주입할 스프링 빈이 없다면 optional.empty 가 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
