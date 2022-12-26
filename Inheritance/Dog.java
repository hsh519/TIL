package Inheritance;

// Animal 추상클래스를 상속받은 Dog 실체클래스
public class Dog extends Animal {
    // 추상클래스 Aniaml 생성자가 기본 생성자기 떄문에 super() 메서드를 생략
    public Dog() {
        this.kind = "포유류";
    }

    // 추상 메서드 sound 를 오버라이딩해 실행 내용을 채운 상태
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
