package Nested;

public class A {
    // 중첩 클래스의 접근 제한

    // 멤버 클래스는 인스턴스 필드의 초기값에서 객채를 생성할 수 있다.
    B field1 = new B();
    C field2 = new C();

    // 멤버 클래스는 인스턴스 메서드에서 객체를 생성할 수 있다.
    void method1() {
        B var1 = new B();
        C var2 = new C();
    }

    // 정적 멤버 클래스만 정적 필드의 초기값에서 객체를 생성할 수 있다.
    // 인스턴스 멤버 클래스 객체는 A 클래스 객체가 생성되어야만 생성할 수 있는 객체인데 정적 필드의 초기값에서 객체를 생성하게 하면
    // A 클래스 객체가 생성되지 않아도 A 클래스의 정적 필드에 접근해 인스턴스 멤버 클래스 객체를 사용할 수 있게 되기 때문이다.
    //static B field3 = new B();
    static C field4 = new C();

    // 정적 멤버 클래스만 정적 메서드에서 객체를 생성할 수 있다.
    // 인스턴스 멤버 클래스 객체는 A 클래스 객체가 생성되어야만 생성할 수 있는 객체인데 정적 메서드에서 객체를 생성하게 하면
    // A 클래스 객체가 생성되지 않아도 A 클래스의 정적 메서드에 접근해 인스턴스 멤버 클래스 객체를 사용할 수 있게 되기 때문이다.
    static void method2() {
        // B var1 = new B();
        C var2 = new C();
    }

    int field5;
    void method3() {}

    static int field6;
    void method4() {}

    // 생성자
    A() { System.out.println("A 객체가 생성됨"); }

    // 인스턴스 멤버 클래스
    class B {
        B() { System.out.println("B 객체가 생성됨"); }
        int field1;
        void method1() {
            // 인스턴스 멤버 클래스는 A 클래스의 모든 필드, 메서드에 접근 가능
            field5 = 10;
            method3();

            field6 = 10;
            method4();
        }

        // 정적 필드, 메서드 작성 불가
        // static int field2;
        // static void method2() {}
    }

    // 정적 멤버 클래스
    static class C {
        C() { System.out.println("C 객체가 생성됨"); }
        int field1;
        static int field2;
        void method1() {
            // 정적 멤버 클래스는 A 클래스의 정적 필드, 메서드에만 접근 가능
            // A 클래스의 인스턴스 필드, 메서드는 A 클래스 객체가 생성되어야 접근 가능. 그런데 정적 멤버 클래스가 A 클래스의 인스턴스 필드, 메서드에 접근하게 되면
            // A 클래스 객체를 생성하지 않고 정적 멤버 클래스 객체만 생성하기 때문에 없는 필드, 메서드에 접근 시도를 하는 꼴이 된다.
            // field5 = 10;
            // method3();

            field6 = 10;
            method2();
        };
        static void method2() {};
    }

    void method() {
        // 로컬 클래스
        // 로컬 클래스는 메서드가 사용될 떄만 생성되어야 하기 때문에 메서드 내부에 로컬 클래스 객체를 생성하고 사용해야 한다.
        class D {
            D() { System.out.println("D 객체가 생성됨"); }
            int field1;
            void method1() {};

            // 정적 필드, 메서드 작성 불가
            // static int field2;
            // static void method2() {}
        }
        D d = new D();
        d.field1 = 3;
        d.method1();
    }
}
