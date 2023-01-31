package Interface;

public interface MyInterface {
    // 기존에 구현되어있는 method 메서드
    public void method();

    // 새로운 기능인 newMethod 메서드
    default void newMethod() {
        System.out.println("새로운 기능을 추가했어요.");
    }

    /*
    // 디폴트 메서드를 허용한 이유
    // 새 기능 newMethod 메서드를 추상 메서드로 선언하면 기존 구현 클래스도 싹 다 바꿔야하는 문제가 발생
    // 따라서 이런 경우는 디폴트 메서드로 선언한다.
    public void newMethod();
     */
}
