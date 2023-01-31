package Nested;

public class Anonymous2 {
    /*
    익명 구현 객체

    익명 구현 객체는 인터페이스를 구현해야만 생성할 수 있다.
    그러나 구현 클래스를 일회성으로 사용할 경우 구현 클래스를 만드는 것보다 익명 구현 객체를 생성해서 사용하는 것이 더 좋다
    일회성으로 사용하는 경우는 필드의 초기값, 로컬 변수의 초기값, 매개값등이 있다. 따라서 익명 구현 객체는 이런 곳에 주로 사용된다.
    익명 구현 객체 -> new 인터페이스() { ... }
    인터페이스() {...} 는 해당 인터페이스의 추상 메서드를 구현하고 필요하면 필드, 메서드를 선언한다. 그 뒤 new 연산자로 익명 구현 객체를 생성한다.
    당연하게도 구현 클래스에 작성한 필드, 메서드는 외부에서 접근이 불가능하며 내부에서만 접근이 가능하다.
     */

    // 익명 구현 객체를 필드의 초기값으로 사용
    RemoteControl rc = new RemoteControl() {
        // 인터페이스의 추상메서드를 구현한 실체 메서드
        @Override
        public void turnOn() {
            System.out.println("tv를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("tv를 끕니다.");
        }
    };

    // 익명 구현 객체를 로컬변수의 초기값으로 사용
    void method() {
        RemoteControl localVar = new RemoteControl() {
            // 인터페이스의 추상메서드를 구현한 실체 메서드
            @Override
            public void turnOn() {
                System.out.println("audio를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("audio를 끕니다");
            }
        };
        localVar.turnOn();
        localVar.turnOff();
    }

    // 인터페이스 타입 변수를 매개변수로 지정한 메서드. 매개값으로 구현 객체가 들어오면 구현 객체는 자동 타입 변환이 일어나 인터페이스 타입이 된다.
    // 매개값으로 어떤 구현 객체가 들어오냐에 따라 결과값을 다양하게 얻을 수 있다.
    void method2(RemoteControl rc) {
        rc.turnOn();
        rc.turnOff();
    }
}
