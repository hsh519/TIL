package Class;

public class Class {
    public static void main(String[] args) {
        example1();
        example2();
    }
    public static void example1() {
        // new 클래스() 형태로 인스턴스 생성
        // 클래스 -> 설계도
        // 인스턴스 -> 클래스를 사용해서 만든 객체
        // 1. 클래스 설계, 2. 인스턴스 생성, 3. 인스턴스 이용
        // 인스턴스는 힙 영역에 생성되며 클래스 변수는 인스턴스의 주소값을 가지고 있음

        // Student 클래스와 같은 패키지 내에 존재하기 때문에 객체 생성 가능
        // s1 은 Student 객체의 주소값을 가짐
        Student s1 = new Student();
        System.out.println("s1 변수가 Student 객체를 참조합니다.");

        // s2 는 다른 Student 객체의 주소값을 가짐
        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
        System.out.println();
    }
    public static void example2() {
        // 필드(클래스 멤버 변수)
        // 필드는 객체의 고유 데이터, 객체가 가져야 할 부품, 객체의 현재 상태 데이터를 저장
        // 필드는 어디에 위치해도 상관없지만 메서드, 생성자 내부는 안됨
        // 타입 필드명 형태로 필드 선언. 초기화 가능
        // 초기값이 없을 시 타입의 기본값으로 초기화
        // 클래스 내부 생성자나 메서드에선 필드 접근 가능
        // 클래스 외부에선 반드시 인스턴스를 생성한 후에 필드 접근 가능
        // 인스턴스를 생성해야 필드, 생성자, 메서드가 존재하기 때문
        // 클래스변수.필드 로 필드를 불러올 수 있음
        // .(도트 연산자) -> 객체 접근 연산자. 객체가 가지고 있는 필드나 메서드를 사용할 때 사용

        // Car 클래스로 myCar 인스턴스 생성
        Car myCar = new Car();

        // 객체를 생성했기 때문에 필드, 메서드를 사용할 수 있음
        // 도트 연산자를 통해 객체의 필드 사용
        System.out.println("제작 회사 : " + myCar.company);
        System.out.println("모델명 : " + myCar.model);
        System.out.println("색깔 : " + myCar.color);
        System.out.println("최고 속도 : " + myCar.maxSpeed);
        System.out.println("현재 속도 : " + myCar.speed);

        // myCar 인스턴스의 speed 필드값 변경
        myCar.speed = 60;
        System.out.println("현재 속도 : " + myCar.speed);
        System.out.println();
    }

}
