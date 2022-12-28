package Nested;

public class Outter {
    /*
    로컬 클래스에서 사용 제한

    로컬 클래스가 바깥 클래스의 필드, 메서드를 사용하는 것에는 문제가 없다.
    문제는 매개 변수와 로컬 변수. 로컬 클래스의 객체는 메서드 실행이 끝나도 힙 메모리에 존재해서 계속 사용할 수 있다.
    그러나 매개 변수와 로컬 변수는 메서드 실행이 끝나면 스택 메모리에서 사라지기 때문에 문제가 발생한다.
    따라서 로컬 클래스는 매개 변수와 로컬 변수의 값을 복사해서 로컬 클래스 내부에 두고 사용한다.
    또한 매개 변수와 로컬 변수가 중간에 수정되면 복사한 값과 달라지기 때문에 final 로 선언해 수정을 막는다.
    자바 7 이전엔 로컬 클래스가 final 로 선언하지 않은 매개 변수나 로컬 변수를 사용하면 컴파일 에러가 발생한다.
    자바 8 이후에는 매개 변수와 로컬 변수에 final 이 없어도 final 특성을 내장하게 됬으며
    final 유무의 차이는 로컬 클래스의 내부 복사 위치가 되었다.
    final 이 있는 변수는 로컬 클래스의 메서드 내부에, final 이 없는 변수는 로컬 클래스의 필드에 복사된다.
     */

    /*
    자바 7 이전
    public void method(final int arg) {
        final int localVariable = 1;
        arg = 100; (x)
        localVariable = 100; (x)

        class Inner {
        public void method() {
        int result = arg + localVariable;
            }
        }
    }
     */

    // 자바 8 이후
    public void method2(int arg) {
        int localVariable = 1;
        // arg = 100;
        // localVariable = 100;
        class Inner {
            public void method() {
                int result = arg + localVariable;
            }
        }
    }

    /*
     중첩 클래스에서 바깥 클래스 참조 얻기

     this 는 객체 자신의 참조이다. 따라서 중첩 클래스 안에서 this 를 사용하면 중첩 클래스 자신의 참조를 뜻한다.
     만약 바깥 클래스의 참조를 얻고싶다면 바깥 클래스.this 를 사용하면 된다.
     */

    String field = "Outter-field";

    void method() {
        System.out.println("Outter-method");
    }

    class Nested {
        String field = "Nested-field";
        void method() {
            System.out.println("Nested-field");
        }
        void print() {
            System.out.println(this.field); // Nested 객체의 field 필드
            this.method(); // Nested 객체의 method 메서드
            System.out.println(Outter.this.field); // Outter 객체의 field 필드
            Outter.this.method(); // Outter 객체의 method 메서드
        }
    }

}
