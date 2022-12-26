package Interface;

import OtherPackage.D;
import hankook.B;

public class Interface {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
        example8();
        example9();
        example10();

    }
    // 인터페이스 역할
    public static void example1() {
        // 인터페이스 추상메서드 사용
        RemoteControl rc = null;
        rc = new Television();
        rc.turnOn();
        rc.turnOff();

        rc = new Audio();
        rc.turnOn();
        rc.turnOff();

    }
    public static void example2() {
        // 디폴트 메서드 사용
        RemoteControl rc = null;
        rc = new Television();
        rc.setMute(true);

        rc = new Audio();
        rc.setMute(true);
    }
    public static void example3() {
        // 정적 메서드 사용
        RemoteControl.changeBattery();
    }
    public static void example4() {
        // 익명 구현 객체
        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("익명함수로 만든 turnOn 메서드");
            }
            @Override
            public void turnOff() {
                System.out.println("익명함수로 만든 turnOff 메서드");
            }
            @Override
            public void setVolume(int volume) {
                System.out.println("익명함수로 만든 setVolume 메서드");
            }
        };
    }
    public static void example5() {
        // 자동 타입 변환, 필드의 다형성
        Car car = new Car();
        car.run();

        /*
        // 인터페이스 배열로 객체 관리 하기 전 코드
        car.frontLeftTire = new KumhoTire();
        car.frontRightTire = new KumhoTire();
         */
        // 인터페이스 베열로 객체 관리
        car.tires[0] = new KumhoTire();
        car.tires[1] = new KumhoTire();
        car.run();
    }
    public static void example6() {
        // 매개변수의 다형성

        Drive drive = new Drive();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        drive.drive(bus);
        drive.drive(taxi);
    }
    public static void example7() {
        // 강제 타입 변환, 객체 타입 확인
    }
    public static void example8() {
        // 인터페이스 확장
    }
    public static void example9() {
        // 디폴트 메서드와 인터페이스 확장
    }
    public static void example10() {
        // 디폴트 메서드가 있는 인터페이스 상속
    }
}
