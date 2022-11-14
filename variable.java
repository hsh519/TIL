public class variable {
    public static void main(String[] args) {
       example1();
       example2();
       example3();
       example4();
       example5();
    }

    public static void example1() {
        // 정수형 변수 value 에 10 저장. 변수 선언과 동시에 초기화
        // 소스 코드 내에서 직접 표기된 값 => 리터럴. 10 은 정수 리터럴
        // 상수는 값을 한 번 저장하면 변하지 않는 변수. 리터럴과 다른 개념
        int value = 10;

        // 정수형 변수 result 에 value 변수 값의 10을 더한 값 저장
        // 변수가 대입 연산자 우측에 올 때는 변수의 저장된 값으로 치환
        int result = value + 10;

        System.out.println(result); // 20
    }

    public static void example2() {
        int num1 = 15;
        if(num1 > 10) {
            // num2 는 if 문 내에서만 유효한 변수
            int num2 = num1 - 10;
        }
        // 변수 num2 는 if 문 내에서만 유효한 변수기 때문에 아래 코드는 컴파일 에러가 발생
        //int num3 = num1 + num2 + 5;

        int num3 = num1 + 5;
        System.out.println(num3); // 20

    }

    public static void example3() {
        // byte 타입 수의 범위는 -128 ~ 127. 범위에 벗어난 숫자는 컴파일 에러 발생
        byte var1 = -128;
        byte var2 = -30;
        byte var3 = 0;
        byte var4 = 30;
        byte var5 = 127;
        //byte var6 = 128; 에러

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
    }

    public static void example4() {
        byte var1 = 125;
        int var2 = 125;

        // var1 변수에 128이 byte 범위에 벗어난 수라서 제일 최소값인 -128을 저장
        // 처음에 올바른 값이 들어갔다 하더라도 실행 중에 값의 범위에 벗어난 수가 들어가면 쓰레기값이 저장
        // 엉터리 값(-128) => 쓰레기값
        for(int i=0; i<5; i++) {
            var1++;
            var2++;
            System.out.println("var1: " + var1 + "\t" + "var2: " + var2);
        }
    }
    public static void example5() {
        // char 은 정수형 타입이지만 유니코드를 저장하기 위해 만들어졌기 때문에 문자형 타입으로 쓰임
        // 유니코드, 정수, 문자를 넣으면 문자로 출력
        // 음수가 없어 수의 범위가 0 ~ 65535 이다
        char c1 = 'A'; // 문자로 입력
        char c2 = 65; // 10진수로 입력
        char c3 = '\u0041'; // 16진수로 입력. 유니코드라는 의미에서 \u 를 앞에 붙임

        char c4 = '가';
        char c5 = 44032;
        char c6 = '\uac00';

        int uniCode = c1; // 유니코드를 알고싶을땐 정수형 타입 int 에 문자를 넣으면 된다.

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(uniCode);
    }
}
