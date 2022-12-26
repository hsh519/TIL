package Inheritance;

import OtherPackage.D;

public class Inheritance {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
        example8();
    }
    public static void example1() {
        // 상속
        // 부모클래스가 자식클래스에게 물려주는 행위
        // 자식클래스는 부모클래스에서 물려 받은것을 사용할 수 있다.
        // 부모클래스를 상위클래스라고도 하며, 자식클래스를 하위클래스,파생클래스라고도 한다.
        // 이미 개발된 클래스를 가져다 재사용해 코드의 중복을 줄여준다.
        // 부모클래스에서 private 접근제한 필드와 메서드는 상속 대상에서 제외
        // 부모클래스와 자식클래스가 다른 패키지에 존재하면 default 접근제한 필드와 메서드 또한 상속 대상에서 제외
        // class 자식클래스 extends 부모클래스 {}
        // 상속은 하나의 부모클래스만 가능하다.(다중 상속x)

        // CellPhone 클래스를 상속받은 DmbCellPhone 클래스
        DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);

        // CellPhone 클래스로부터 상속받은 필드
        System.out.println("모델 : " + dmbCellPhone.model);
        System.out.println("색상 : " + dmbCellPhone.color);

        // DmbCellPhone 클래스의 필드
        System.out.println("채널 : " + dmbCellPhone.channel);

        // CellPhone 클래스(부모클래스)로부터 상속받은 메서드
        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("여보세요");
        dmbCellPhone.receiveVoice("안녕하세요");
        dmbCellPhone.sendVoice("반갑습니다");
        dmbCellPhone.handUp();
        dmbCellPhone.powerOff();

        // DmbCellPhone 클래스의 메서드
        dmbCellPhone.turnOnDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();

        System.out.println();
    }
    public static void example2() {
        // 부모 생성자 명시적 호출
        // 자식 객체가 생성되려면 부모 객체가 먼저 생성되고 난 후 자식 객체가 생성
        // 객체가 생성되려면 생성자가 필요
        // 즉, 자식클래스 생성자에 먼저 부모 객체를 생성하고 자식 객체를 생성하는 코드가 필요
        // 자식클래스 생성자에서 부모 객체를 생성하는 메서드 -> super(매개값, ...)
        // 자식 객체보다 먼저 생성되어야 하기 때문에 자식클래스 생성자의 첫 줄에 위치
        // 부모클래스 생성자가 기본 생성자일 경우 super() 메서드 생략 가능하며 작성해도 문제 없다.
        // 부모클래스 생성자가 매개 변수가 있는 생성자일 경우 생략이 불가능하며 super(매개값, ...) 형태로 명시적으로 작성해야 한다.

        // People 클래스를 상속받은 Student 클래스
        Student student = new Student("홍석환", "000519-1234567", 1);

        // People 클래스로부터 상속받은 필드
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);

        // Student 클래스의 필드
        System.out.println("studentNo : " + student.studentNo);

        System.out.println();
    }
    public static void example3() {
        // 부모 메서드 재정의(오버라이딩)
        // 상속된 일부 메서드를 자식클래스에서 재정의하는 것
        // 오버라이딩되면 부모클래스에 있는 동일한 이름의 메서드는 숨겨져 해당 메서드가 호출될 때 자식클래스에서 재정의한 메서드가 호출
        // 오버라이딩 규칙으로는
        // 1. 부모클래스와 형태가 동일한 메서드(매개변수 타입과 개수, 리턴타입, 클래스명)
        // 2. 접근 제한을 해당 부모클래스 메서드보다 더 강하게 가지는 것x. 단 약하게 가지는 것은 가능
        // 3. 새로운 예외를 throws 할 수 없다.
        // Override 어노테이션을 쓰면 해당 메서드가 정확히 오버라이딩 됬는지를 확인(위 규칙을 확인해줌)해주기 떄문에
        // 개발자의 실수가 줄어들어 사용하는 것이 좋다.

        int r = 10;

        // 부모 객체 calculator 와 자식 객체 computer 생성
        Calculator calculator = new Calculator();
        Computer computer = new Computer();

        // 부모 객체 areaCircle 메서드 호출
        System.out.println("원면적 : " + calculator.areaCircle(r));
        System.out.println();

        // 자식클래스에서 재정의했기 떄문에 부모클래스 areaCircle 메서드는 숨겨지고 자식클래스에서 재정의한 areaCircle 메서드 호출
        System.out.println("원면적 : " + computer.areaCircle(r));
        System.out.println();
    }
    public static void example4() {
        // 오버라이딩 됬을 때 부모 메서드 호출
        // 자식클래스에서 오버라이딩 하고 난 뒤 오버라이딩 하기 전에 메서드(=부모클래스 메서드)를 사용할 때가 생길 수 있다.
        // 오버라이딩 했을 때 부모클래스 메서드가 숨김 처리되기 때문에 super 키위드를 사용해서 불러낼 수 있다.
        // super.부모클래스 메서드

        // Airplane 클래스를 상속 받은 SupersonicAirplane 클래스
        SupersonicAirplane sa = new SupersonicAirplane();

        sa.takeOff();
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
        System.out.println();
    }

    // final 클래스, final 메서드
    // 클래스에 final 키워드를 붙이면 상속 할 수 없는 클래스가 된다.
    // 메서드에 final 키워드를 붙이면 오버라이딩 할 수 없는 메서드가 된다.

    // protected 접근 제한자
    // protected 접근 제한자는 같은 페키지와 다른 패키지의 자식클래스에만 접근을 허용한다.
    // protected 접근 제한자는 필드, 메서드, 생성자에만 사용할 수 있다.
    // protected 접근 제한자와 같은 패키지에 있는 클래스는 직접 접근할 수 있다.
    // protected 접근 제한자와 다른 패키지지만 자식클래스인 경우는 생성자에서 super() 메서드로 부모클래스 생성자를 호출해서 접근 할 수 있다.

    public static void example5() {
        // 자동 타입 변환과 다형성
        // 다형성은 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질을 말한다.
        // 타입 변환은 데이터 타입을 다른 데이터 타입으로 변환하는 행위를 말한다.
        // 자바는 다형성을 위해서 자식 타입이 부모 타입으로 자동 타입 변환 가능하도록 한다.
        // 즉, 부모타입으로 설정된 변수에 여러 자식 객체를 대입할 수 있다(=다형성)
        // 예를 들면 어떤 음식의 레시피를 작성할 때 재료 중에 우유가 있다면 서울우유, 연세우유 등 우유만 맞다면 어떤 우유든지 다 사용할 수 있는 것이다.
        // 꼭 부모가 아니라도 상위 타입이면 자동 타입 변환이 가능하다.
        // 이렇게 부모 타입으로 타입 변환하면 부모의 필드와 메서드만 접근 할 수 있다.
        // 단, 오버라이딩 된 메서드라면 자식클래스 메서드가 호출이 된다.

        Car car = new Car();

        // 배열로 관리했을 때의 코드
        for(int i=0; i<=5; i++) {
            int problemLocation = car.run();

            if(problemLocation != 0) {
                System.out.println(car.tires[problemLocation-1].location + " HankookTire로 교체");
                car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
            }
/*
            // 하나의 배열로 관리하기 전 코드
            switch (problemLocation) {
                case 1:
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    // car 객체의 frontLeftTire 필드는 Tire 타입
                    // Tire 클래스를 상속 받은 HankookTire 클래스가 오면 자동 타입 변환된다
                    car.frontLeftTire = new HankookTire("앞왼쪽", 15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    // car 객체의 fronRightTire 필드는 Tire 타입
                    // Tire 클래스를 상속 받은 KumhoTire 클래스가 오면 자동 타입 변환된다
                    // 다형성 덕분에 같은 타입이지만 다른 객체를 저장해 여러 결과를 만들어낼 수 있다
                    car.frontRightTire = new KumhoTire("앞오른쪽", 13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 HankookTire로 교체");
                    car.backLeftTire = new HankookTire("뒤왼쪽", 14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 KumhoTire로 교체");
                    car.backRightTire = new KumhoTire("뒤오른쪽", 17);
                    break;
            }
 */
            System.out.println("---------------------------------");
        }
    }
    public static void example6() {
        // 매개변수의 다형성
        // 매개변수를 부모 타입으로 지정해 놓고 매개값으로 상속 받은 자식 객체가 전달된다면 마찬가지고 자동 타입 변환이 일어난다.
        // 오버라이딩 한 메서드는 자식클래스 메서드가 호출되기 때문에 실행문으로 해당 메서드를 호출하도록 하면 다양한 결과를 얻을 수 있다.


        Driver driver = new Driver();

        // Vehicle 클래스를 상속 받은 Bus, Taxi 클래스의 객체 생성
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        // driver 객체의 drive 메서드는 vehicle 타입 객체의 run 메서드를 호출
        // bus 와 taxi 객체는 Vehicel 의 자식클래스로 생성한 객체이기 때문에 매개 값으로 들어가면 Vehicle 타입으로 자동 타입 변환
        // 이때 bus 와 taxi 객체에서 run 메서드를 오버라이딩 했기 때문에 자식클래스의 run 메서드가 호출되며 다양한 결과를 얻을 수 있다.
        driver.drive(bus);
        driver.drive(taxi);
        System.out.println();
    }
    public static void example7() {
        // 강제 타입 변환, 객체 타입
        // 강제 타입 변환은 부모 타입에서 자식 타입으로 변환되는 것
        // 자식클래스에 있는 필드와 메서드를 사용해야 한다면 강제 타입 변환하면 된다
        // 모든 부모 타입이 강제 타입 변환이 되는 것이 아닌 자식 타입에서 부모 타입으로 자동 타입 변환된 객체만 가능
        // 따라서 강제 타입 변환을 하기 위해 자동 타입 변환된 객체인지 파악하는 것이 우선
        // 어떤 객체가 자동 타입 변환된 것인지 파악이 힘들기 때문에 객체 타입을 확인하는 연산자를 사용
        // 객체 instanceof 클래스 -> true 면 해당 타입으로 객체가 생성된 것. false 면 해당 타입으로 객체가 생성된게 아닌 것.
        // 타입 확인을 안하고 강제 타입 변환을 하면 ClassCastException 예외가 발생할 수 있다.
        // 예외가 발생하면 프로그램이 즉시 종료되기 떄문에 꼭 확인해야 한다.

        // 자식 객체를 부모 타입 parent 변수에 저장. 자동 타입 변환
        Parent parent = new Child();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        // parent 변수를 자식 타입으로 강제 타입 변환 후 child 변수에 저장
        // 예외가 발생할 수 있다
        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();

        // 부모 객체를 부모 타입 p 변수에 저장
        Parent p = new Parent();

        // p 는 부모 타입으로 객체가 생성됬으므로 true
        System.out.println(p instanceof Parent);
        // p 는 자식 타입으로 객체가 생성된게 아니므로 false
        System.out.println(p instanceof Child);
        // child 는 부모클래스로 자동 타입 변환이 되므로 부모 타입으로 만들어졌다고 볼수 있으므로 true
        System.out.println(child instanceof Parent);
        // child 는 자식 타입으로 객체가 생성됬으므로 true
        System.out.println(child instanceof Child);
        System.out.println();
    }
    public static void example8() {
        // 추상 클래스
        // 추상이란 단어의 뜻은 실체 간의 공통되는 특성을 추출한 것
        // 추상 클래스는 실체 간 공통되는 특성을 추출한 클래스.
        // 실체 클래스는 인스턴스를 생성할 수 있는 클래스. 즉, 실체 클래스와 추상 클래스로 나뉘며
        // 실체 클래스는 추상 클래스를 상속 받아 특성을 추가해서 만든다.
        // 추상 클래스는 단지 실체 간의 공통되는 특성을 추출한 것이기 때문에 인스턴스를 생성하지 못한다.
        // 추상 클래스를 사용하면 실체 클래스의 필드명 메서드명을 통일할 수 있고, 실체 클래스를 작성할 때 시간을 절약해준다.
        // public abstract class 추상클래스 { 필드 생성자 메서드 } -> 추상클래스 선언
        // 추상클래스에 공통적인 특성을 실체 클래스에서 생성해야하기 때문에 생성자는 필수로 작성해야 한다.

        // 추상 메서드
        // 추상 메서드는 선언부만 있고 실행 내용인 {} 가 없는 메서드를 말한다.
        // 실체 간에 공통적인 특성을 가지지만 실행 내용이 다른 경우가 존재한다.
        // 예를 들면 모든 동물은 울음소리라는 특성을 가지지만 울음소리가 각기 다르다.
        // 이럴 경우 추상 클래스에서 작성할 수 없게 된다. 그렇다고 실체 클래스에 넘기면 특성을 까먹고 안적는 경우도 발생한다.
        // 그래서 추상 클래스에서 추상 메서드를 선언하고 실체 클래스에서 실행 내용을 작성 안하면 컴파일 에러를 발생하도록 한다.
        // 에러를 발생시키지 않으려면 추상 메서드를 꼭 실체 클래스가 채워야 한다.

        Dog dog = new Dog();
        dog.sound();
        System.out.println("--------");

        // 자식 타입에서 부모 타입으로 자동 타입 변환
        Animal animal = new Dog();
        animal.sound();
        System.out.println();
    }
}
