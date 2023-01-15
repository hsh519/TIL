package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 싱글톤 즉, 객체가 하나라서 생기는 문제. 사용자 A,B 모두 같은 price 필드에 접근
        // ThreadA -> A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB -> B 사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);
        // ThreadA -> A 사용자 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);


    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}