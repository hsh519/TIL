package Interface;

public interface Child extends Parent {

    // 상속 받은 디폴트 메서드를 추상 메서드로 선언
    @Override
    public void defMethod();
}
