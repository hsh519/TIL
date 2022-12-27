package Interface;

public class NewClass implements MyInterface {
    // 새 기능을 추가한 MyInterface 인터페이스를 가진 NewClass 구현 클래스
    // 이 클래스 또한 아무 문제없이 잘 작동한다.
    @Override
    public void method() {
        System.out.println("새로운 기능을 추가한 후 만든 클래스");
    }

    @Override
    public void newMethod() {
        System.out.println("디폴트 메서드도 오버라이딩 할 수 있어요.");
    }
}
