package Nested;

public class Button {
    // 중첩 인터페이스
    OnClickListener listener;

    // 인터페이스를 클래스 내부에 선언하고 해당 인터페이스 타입 변수를 매개 변수로 받는 메서드를 만들면 중첩 인터페이스를 구현한 객체만 받도록 할 수 있다.
    // 즉, 중첩 인터페이스 구현 클래스와 바깥 클래스는 긴밀한 관계가 있다고 볼 수 있다. (매개 변수로 중첩 인터페이스 구현 클래스의 객체만 받을 수 있기 때문)
    void setOnClickListener(OnClickListener listener) {
        listener.onClick();
    }

    interface OnClickListener {
        void onClick();
    }
}
