package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HelloRombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloRombok helloRombok = new HelloRombok();
        helloRombok.setName("name");

        String name = helloRombok.getName();
        System.out.println("helloRombok = " + helloRombok);
    }
}
