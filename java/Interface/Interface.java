package Interface;

import OtherPackage.C;
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
    /*
    인터페이스는 객체의 사용 방법을 정의한 타입(객체 사용 설명서 같은 것)
    인터페이스를 참고해서 객체를 만들면 어떤 객체든 인터페이스에서 정의한 필드, 메서드는 가지고 있으며 이름도 같다.
    인터페이스는 개발 코드와 객체의 중간다리 역할
    개발 코드는 인터페이스의 메서드를 호출하면 인터페이스가 알아서 객체의 메서드를 호출해서 리턴값을 얻어오기 때문에
    개발 코드는 인터페이스의 메서드만 알고 있으면 된다.
    또한 개발 코드에서 객체에 맞춰서 필드와 메서드명을 수정할 필요도 없다.
    인터페이스에서 정의한 그대로 객체가 쓰기 때문에 사용할 객체만 변경해준다면 실행 결과도 문제없이 잘 나온다.
    */

    public static void example1() {
        /*
        인터페이스 추상메서드 사용

        구현 객체가 인터페이스 타입 변수에 대입되면 개발 코드는 인터페이스 메서드를 호출할 수 있으며
        인터페이스는 인터페이스 타입 변수에 저장된 구현 객체에서 해당 메서드를 호출해 리턴값을 얻어온다.
         */
        RemoteControl rc = null;
        rc = new Television(); // 인터페이스 타입 변수 rc 에 Television 구현 객체 생성 후 저장
        // 이렇게 개발 코드가 인터페이스 메서드를 호출하면 인터페이스가 rc 에 저장된 구현 객체에서 메서드를 호출
        rc.turnOn();
        rc.turnOff();

        rc = new Audio();
        rc.turnOn();
        rc.turnOff();
        System.out.println();

    }
    public static void example2() {
        /*
         디폴트 메서드 사용

         디폴트 메서드는 이미 구현되있지만 구현 객체가 생성된 후 사용할 수 있다.
         인터페이스명.디폴트메서드 -> 사용할 수 없다.
         디폴트 메서드는 오버라이딩 가능하다. 오버라이딩 하면 오버라이딩한 메서드가 호출된다.
         */
        RemoteControl rc = null;
        rc = new Television(); // 인터페이스 타입 변수 rc 에 Television 구현 객체 생성 후 저장
        rc.setMute(true); // 구현 객체이기 때문에 디폴트 메서드를 사용할 수 있다.

        rc = new Audio();
        rc.setMute(true); // 구현 객체에서 오버라이딩한 디폴트 메서드가 호출된다.
        System.out.println();
    }
    public static void example3() {
        /*
        정적 메서드 사용

        정적 메서드는 인터페이스로 바로 호출이 가능한 메서드
         */
        // RemoteControl 인터페이스에서 바로 호출한 changeBattery 메서드
        RemoteControl.changeBattery();
        System.out.println();
    }
    public static void example4() {
        /*
        익명 구현 객체

        일회성의 구현 객체를 만들기 위해서 구현클래스를 만드는 것은 비효율적
        자바는 구현클래스를 만들지 않고도 구현 객체를 만들수 있는 방법을 제공 -> 익명 구현 객체
        익명 구현 객체는 하니의 실행문이므로 끝에 반드시 세미콜론을 붙여야 한다.
        new 인터페이스() { 실체 메서드(필수) + 추상 메서드를 제외한 오버라이딩 할 메서드(선택) }
         */

        // 익명 구현 객체를 만들어 인터페이스 타입 변수 rc 에 저장
        RemoteControl rc = new RemoteControl() {
            // 인터페이스의 추상 메서드는 모두 실행 내용을 작성해줘야 한다.
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
        /*
         자동 타입 변환, 필드의 다형성

         인터페이스를 사용하기 위해서 인터페이스 타입 변수에 구현 객체를 대입했다. 이때 구현 객체는 자동 타입 변환이 된다.
         여기서 자동 타입 변환이란 구현 객체가 인터페이스 타입으로 변환되는 것을 의미한다.
         인터페이스를 참고해서 만든 구현 객체들은 사용 방법이 동일하다.
         따라서 어떤 구현 객체가 인터페이스 타입 변수에 대입되냐에 따라 다양한 결과르 얻는다. 인터페이스의 대형성이다.
         이 인터페이스 타입 변수가 어떤 클래스의 필드로 선언됬을 때 필드의 다형성이라고 한다.
         */
        Car car = new Car();
        car.run();

        /*
        인터페이스 배열로 객체 관리 하기 전 코드
        Tire 인터페이스 타입 필드에 Tire 인터페이스를 가지는 구현 객체 KumhoTire 를 대입 -> 필드의 다형성
        구현 객체는 Tire 인터페이스 타입이 된다 -> 자동 타입 변환
        car.frontLeftTire = new KumhoTire();
        car.frontRightTire = new KumhoTire();
         */

        // 인터페이스 베열로 객체 관리
        // 필드가 같은 타입일 경우 배열로 관리하는 것이 좋다.
        // 배열로 관리할 경우 제어문에서 가장 큰 이득을 본다.
        car.tires[0] = new KumhoTire();
        car.tires[1] = new KumhoTire();
        car.run();
        System.out.println();
    }
    public static void example6() {
        /*
         매개변수의 다형성

         위에서 말했듯 인터페이스 타입 변수에 어떤 구현 객체가 들어가냐에 따라 결과가 달라진다.
         이 인터페이스 타입 변수가 매개변수로 사용됬을 때 매개변수의 다형성이라고 한다.
         */

        Drive drive = new Drive();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // Vehicle 인터페이스 타입에 구현 객체 bus, taxi 대입
        // 자동 타입 변환이 되며 구현 객체의 run 메서드를 호출(drive 메서드가 run 메서드를 호출하도록 했기 때문이다)
        drive.drive(bus);
        drive.drive(taxi);
        System.out.println();
    }
    public static void example7() {
        /*
         강제 타입 변환, 객체 타입 확인

         자동 타입 변환이 되면 인터페이스에 선언된 메서드만 사용할 수 있다.
         이떄 구현 객체에만 존재하는 메서드를 사용하고 싶다면 구현 객체 타입으로 변환해야 햔댜. 이것이 강제 타입 변환이다.
         강제 타입 변환 -> (구현 객체 타입) 자동 타입 변환된 구현 객체
         이떄 우리가 작성한 구현 객체 타입과 실제 구현 객체의 타입이 다르다면 ClassCastException 예외가 발생한다.
         따라서 강제 타입 변환 하기 전에 구현 객체가 어떤 타입으로 만들어진건지 확인할 필요가 있다.
         instanceof 연산자를 이용해 확인 할 수 있다. 사용볍 -> 구현 객체 instanceof 구현 객체 타입
         구현 객체가 구현 객체 타입이면 true, 아니면 false
         */
        Drive drive = new Drive();
        Vehicle bus = new Bus(); // 자동 타입 변환

        drive.drive(bus);

        // 인터페이스 타입 변수 bus 에 들어있는 구현 객체가 Bus 타입인지 아닌지 확인
        if(bus instanceof Bus) {
            // 맞다면 강제 타입 변환 후 구현 객체에만 존재하는 checkFare 메서드 호출
            Bus newBus = (Bus) bus;
            newBus.checkFare();
        }
        System.out.println();
    }
    public static void example8() {
        /*
         인터페이스 상속

         인터페이스 또한 상속할 수 있다.
         인터페이스를 상속 받으면 상속 받은 인터페이스의 추상 메서드에 대한 실체 메서드도 가지고 있어야 한다.
         */

        // 인터페이스A, 인터페이스B 는 인터페이스C 의 부모 인터페이스이기 떄문에
        // 인터페이스A, 인터페이스B 타입 변수에 인터페이스C 를 참고한 구현 객체를 저장할 수 있다.

        // 인터페이스A 타입 변수 ia 에 구현 객체 대입
        InterfaceA ia = new ImplementationC();
        // 인터페이스B 타입 변수 ib 에 구현 객체 대입
        InterfaceB ib = new ImplementationC();
        // 인터페이스C 타입 변수 ic 에 구현 객체 대입
        InterfaceC ic = new ImplementationC();

        ia.methodA();

        ib.methodB();

        ic.methodA();
        ic.methodB();
        ic.methodC();
        System.out.println();

    }
    public static void example9() {
        /*
         디폴트 메서드와 인터페이스 확장

         자바8에 와서 인터페이스에 디폴트 메서드를 추가했다.
         그 이유는 기존 구현 클래스에 영향을 주지 않으면서 인터페이스에 새로운 기능을 추가하기 위해서이다.
         만약 인터페이스에 새 기능을 추가한다면 추상메서드를 작성할 것이다.(자바7에서는 디폴트 메서드와 정적 메서드가 없었다)
         그렇게 되면 기존에 있는 구현 클래스에도 추가된 추상메서드에 대한 실체 메서드를 가져야한다.
         문제는 해당 인터페이스를 가지는 구현 클래스가 천개라고 가정하면 천개의 구현 클래스에 모두 실체 메서드를 작성해주어야 한다.
         그래서 기존 구현 클래스에는 영향을 주지 않으면서 인터페이스에 새 기능을 추가할 수 있는 디폴트 메서드를 자바8에 추가했다.
         사용해도 되고 사용하지 않아도 되며 필요에 의해서 오버라이딩해 사용해도 된다.
         인터페이스 확장을 보다 쉽게 할 수 있게 되었다.
         */

        MyInterface mi = new MyClass();
        MyInterface nmi = new NewClass();

        // 기존 메서드
        mi.method();
        nmi.method();
        // 새로 추가된 메서드
        mi.newMethod();
        nmi.newMethod();
        System.out.println();

    }
    public static void example10() {
        /*
         디폴트 메서드가 있는 인터페이스 상속

         디폴트 메서드가 있는 인터페이스를 상속받을 때 처리 방법이 3가지가 있다.
         1. 디폴트 메서드를 그대로 상속받아 사용
         2. 디폴트 메서드를 오버라이딩해 사용
         3. 디폴트 메서드를 추상 메서드로 선언해 사용
         */

        // 디폴트 메서드를 그대로 상속받아 사용
        Child2 child1 = new Child2() {
        };
        child1.defMethod();

        // 디폴트 메서드를 오버라이딩 해 사용
        Child child2 = new Child() {
            @Override
            public void defMethod() {
                System.out.println("오버라이딩한 디폴트 메서드");
            }
        };
        child2.defMethod();

        // 디폴트 메서드를 추상 메서드 선언해 사용. 구현 클래스에서 실체 메서드를 작성해주어야 한다.
        Child child3 = new Child() {
            public void defMethod() {
                System.out.println("디폴트 메서드를 추상 메서드로 만들어 구현 클래스에서 실체 메서드 작성");
            }
        };
        child3.defMethod();

    }
}
