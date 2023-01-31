package Interface;

public class ImplementationC implements InterfaceC {
    // 인터페이스C 는 인터페이스A, 인터페이스B 를 상속받은 메서드.
    // 따라서 인터페이스A, 인터페이스B 의 추상메서드에 대한 실체메서드도 가지고 있어야 한다

    // 인터페이스A 의 추상메서드에 대한 실체 메서드
    @Override
    public void methodA() {
        System.out.println("methodA 실행");
    }
    // 인터페이스B 의 추상메서드에 대한 실체 메서드
    @Override
    public void methodB() {
        System.out.println("methodB 실행");
    }
    // 인터페이스C 의 추상메서드에 대한 실체 메서드
    @Override
    public void methodC() {
        System.out.println("methodC 실행");
    }
}
