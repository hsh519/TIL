package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/*
Qualifier 어노테이션의 단점은 찾을 때 작성하는 별명과 어노테이션을 사용할 때 작성하는 별명이 달라고 컴파일에서는 오류를 발생시키지 않는 것입니다.
컴파일에선 문제없이 넘어가지만 실행하고나서 오류를 발생합니다.
즉, 체크를 해주지 않아 개발자가 그냥 넘어갈 수도 있기 때문에 어노테이션을 만들어 컴파일 과정에서 처리할 수 있도록 해줍니다.
*/

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
