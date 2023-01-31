package Interface;

public class MyClass implements MyInterface {
    // 기존에 있는 MyInterface 를 가지고 있는 MyClass 구현 클래스
    // 새 기능이 추가되도 에러없이 잘 작동한다.
    @Override
    public void method() {
        System.out.println("추상메서드를 구현했어요");
    }
}
