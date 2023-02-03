package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		// 롬복 적용 테스트
		Hello hello = new Hello();
		hello.setHello("안녕");
		String hello1 = hello.getHello();
		System.out.println("hello1 = " + hello1);

		SpringApplication.run(JpashopApplication.class, args);
	}

}
