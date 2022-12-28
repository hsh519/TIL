package Nested;

public class Nested {

    public static void main(String[] args) {
        example1();
        example2();
        exmaple3();
    }
    public static void example1() {
        /*
        중첩 클래스

        클래스 내부에 선언한 클래스. 어떤 클래스가 특정 클래스와 관걔를 맺을 경우 좋다.
        두 클래스의 멤버들을 서로 쉽게 접근할 수 있는 장점과 외부에는 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다.
        클래스의 멤버로서 선언되는 중첩 클래스를 멤버 클래스, 클래스의 메서드 내부에서 선언되는 중첩 클래스를 로컬 클래스라고 한다.
        멤버 클래스는 객체가 사용 중이라면 재사용이 가능하지만, 로컬 클래스는 메서드가 실행될 때만 사용되고 실행이 끝나면 사라진다.
        멤버 클래스에는 객체가 생성되면 사용할 수 있는 인스턴스 멤버 클래스와 클래스로 바로 접근할 수 있는 정적 멤버 클래스가 있다.
        인스턴스 멤버 클래스는 static 키워드가 없으며 인스턴스 필드, 메서드만 작성할 수 있다.(정적 인스턴스, 메서드 작성 불가)
        정적 멤버 클래스는 static 키워드가 있고 인스턴스 필드, 메서드와 정적 인스턴스, 메서드 모두 작성할 수 있다.
        로컬 클래스는 메서드가 실행되어야 사용되기 때문에 접근 제한자를 붙일 수 없다. 인스턴스 필드, 메서드만 작성할 수 있다.
         */

        A a = new A();

        /*
        인스턴스 멤버 클래스 객체 생성
         인스턴스 멤버 클래스라서 A 클래스 객체가 존재해야 A 클래스 객체 내부에 있는 인스턴스 멤버 클래스에 접근할 수 있고
         인스턴스 멤버 클래스 내부에 있는 인스턴스 필드, 메서드도 사용하려면 인스턴스 멤버 클래스 객체가 존재해야 하기 때문에
         결론적으로 'A 클래스 객체.인스턴스 멤버 클래스 객체' 를 변수에 대입하면 그 변수는 인스턴스 멤버 객체의 필드, 메서드를 사용할 수 있다.
        */
        A.B b = a.new B();
        b.field1 = 3;
        b.method1();

        /*
         정적 멤버 클래스 객체 생성
         A 클래스 내부에 static 으로 선언된 클래스는 A 클래스 객체를 생성할 필요없이 A 클래스에서 접근하면 된다.
         하지만 정적 멤버 클래스 내부에 있는 인스턴스 필드, 메서드를 사용하려면 정적 멤버 클래스 객체가 존재해야 하기 때문에
         'A 클래스.정적 멤버 클래스' 로 정적 멤버 클래스만 객체를 만들어 변수에 대입하면 그 변수는 정적 멤버 객체의 인스턴스 필드, 메서드를 사용할 수 있다.
         정적 멤버 클래스 내부에 있는 정적 필드, 메서드는 정적 멤버 클래스 객채도 생성할 필요가 없어 'A 클래스.정적 멤버 클래스' 에서 바로 접근하면 된다.
         */
        A.C c = new A.C();
        c.field1 = 3;
        c.method1();
        A.C.field2 = 3;
        A.C.method2();

        // 로컬 클래스 객체 생성을 위한 메서드 호출
        a.method();
        System.out.println();
    }
    public static void example2() {
        // 중첩 클래스에서 바깥 클래스 참조 얻기
        Outter outter = new Outter();
        Outter.Nested nested = outter.new Nested();
        nested.print();
        System.out.println();
    }
    public static void exmaple3() {
        /*
        중첩 인터페이스

        클래스의 멤버로 선언된 인터페이스를 말한다.
        인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다.
         */
        Button btn = new Button();
        btn.setOnClickListener(new CallListener());
        btn.setOnClickListener(new MessageListener());
        System.out.println();
    }
    public static void example4() {
        // 익명 자식 객체
        Anonymous anony = new Anonymous();
        anony.field.wake();
        anony.method1();
        anony.method2( new Person() {
            void study() {
                System.out.println("공부합니다.");
            }

            @Override
            public void wake() {
                System.out.println("8시에 일어납니다.");
                study();
            }
        });
    }


}
