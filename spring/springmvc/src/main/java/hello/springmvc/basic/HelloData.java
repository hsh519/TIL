package hello.springmvc.basic;

import lombok.Data;

@Data // getter, setter, toString... 다 만들어 주는 어노테이션
public class HelloData {
    private String username;
    private int age;
}
