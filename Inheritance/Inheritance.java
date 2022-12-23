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
        DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);

        System.out.println("모델 : " + dmbCellPhone.model);
        System.out.println("색상 : " + dmbCellPhone.color);
        System.out.println("채널 : " + dmbCellPhone.channel);

        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("여보세요");
        dmbCellPhone.receiveVoice("안녕하세요");
        dmbCellPhone.sendVoice("반갑습니다");
        dmbCellPhone.handUp();
        dmbCellPhone.powerOff();

        dmbCellPhone.turnOnDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();

        System.out.println();
    }
    public static void example2() {
        // 부모 생성자 명시적 호출
        Student student = new Student("홍석환", "000519-1234567", 1);
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);

        System.out.println();
    }
    public static void example3() {
        // 부모 메서드 재정의(오버라이딩)
        int r = 10;
        Calculator calculator = new Calculator();
        Computer computer = new Computer();

        System.out.println("원면적 : " + calculator.areaCircle(r));
        System.out.println();
        System.out.println("원면적 : " + computer.areaCircle(r));
        System.out.println();
    }
    public static void example4() {
        // 오버라이딩 됬을 때 부모 메서드 호출
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
    // protected 접근 제한자
    public static void example5() {
        // 자동 타입 변환과 다형성
        Car car = new Car();

        for(int i=0; i<=5; i++) {
            int problemLocation = car.run();

            if(problemLocation != 0) {
                System.out.println(car.tires[problemLocation-1].location + " HankookTire로 교체");
                car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
            }
/*
            switch (problemLocation) {
                case 1:
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    car.frontLeftTire = new HankookTire("앞왼쪽", 15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    car.frontRightTire = new HankookTire("앞오른쪽", 13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 HankookTire로 교체");
                    car.backLeftTire = new HankookTire("뒤왼쪽", 14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 KumhoTire로 교체");
                    car.backRightTire = new HankookTire("뒤오른쪽", 17);
                    break;
            }
 */
            System.out.println("---------------------------------");
        }
    }
    public static void example6() {
        // 매개변수의 다형성
        Driver driver = new Driver();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);
        driver.drive(taxi);
        System.out.println();
    }
    public static void example7() {
        // 강제 타입 변환, 객체 타입
        Parent parent = new Child();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();

        Parent p = new Parent();
        System.out.println(p instanceof Parent);
        System.out.println(p instanceof Child);
        System.out.println(child instanceof Parent);
        System.out.println(child instanceof Child);
        System.out.println();
    }
    public static void example8() {
        // 추상 클래스 ,추상 메서드
        Dog dog = new Dog();
        dog.sound();
        System.out.println("--------");
        Animal animal = new Dog();
        animal.sound();
        System.out.println();
    }
}
