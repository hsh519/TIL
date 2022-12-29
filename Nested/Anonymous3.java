package Nested;

public class Anonymous3 {
    /*
    익명 객체의 로컬 변수 사용

    메서드 내의 익명 객체가 바깥 클래스의 필드, 메서드를 사용하는데는 제한이 없지만 메서드의 매개 변수나 로컬 변수를 사용할 때 문제가 발생할 수 있다.
    그 이유는 메서드가 실행하면 익명 객체는 힙 영역에 생성되 메서드 실행이 종료되도 계속 사용할 수 있지만,
    매개 변수나 로컬 변수는 스택 영역에 생성되 메서드 실행이 종료되면 사라지기 때문에 익명 객체에서 사용할 수 없게 되기 때문이다.
    그래서 매개 변수나 로컬 변수를 컴파일할 때 복사해서 익명 객체 내에서 사용한다. 단, 복사한 매개 변수와 로컬 변수의 값이 중간에 수정되면 안되기 떄문에 final 특성을 내제하고 있다.
    final 키워드의 유무는 매개 변수나 로컬 변수의 복사 위치이다.
    final 키워드가 있는 변수는 익명 객체의 메서드 내부에, final 키워드가 없으면 익명 객체의 필드에 복사된다.
     */

    // 접근 제한자에 상관없이 익명 객체가 사용할 수 있다.
    private int field;

    public void method(final int arg1, int arg2) {
        // arg1, arg2, var1, var2 모두 final 특성을 가진다. 따라서 중간에 값을 수정할 수 없다.
        // arg1, var1 은 익명 객체 내 sum 메서드 내부에 복사되고, arg2, var2 는 익명 객체 필드 부분에 복사된다.
        final int var1 = 0;
        int var2 = 0;

        field = 10;

        // arg1 = 10;
        // arg2 = 10;

        // var1 = 10;
        // var2 = 10;

        Calculable calc = new Calculable() {
            @Override
            public int sum() {
                int result = field + arg1 + arg2 + var1 + var2;
                return result;
            }
        };
        // 복사 됬을 때의 코드
        /*
        -> Calculable calc = new Calculable() {
            int arg2 = 매개값;
            int var2 = 0;

            public int sum() {
            int arg1 = 매개값;
            int var1 = 0;

            int result = field + arg1 + arg2 + var1 + var2;
            return result;
            }
        }
        */

        System.out.println(calc.sum());
    }
}
