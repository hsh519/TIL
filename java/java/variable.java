public class variable {
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
       example11();
       example12();
       example13();
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

        System.out.println(var1); // -128
        System.out.println(var2); // -30
        System.out.println(var3); // 0
        System.out.println(var4); // 30
        System.out.println(var5); // 127
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
        char c2 = 65; // 10진수로 입략

        char c4 = '가';
        char c5 = 44032;

        int uniCode = c1; // 유니코드를 알고싶을땐 정수형 타입 int 에 문자를 넣으면 된다.

        System.out.println(c1); // A
        System.out.println(c2); // A
        System.out.println(c4); // 가
        System.out.println(c5); // 가
        System.out.println(uniCode); // 65
    }
    public static void example6() {
        int var1 = 10; // 10진수로 저장
        int var2 = 012; // 8진수로 저장. 앞에 0을 붙임
        int var3 = 0xA; // 16진수로 저장. 앞에 0x를 붙임

        System.out.println(var1); // 10
        System.out.println(var2); // 10
        System.out.println(var3); // 10
    }
    public static void example7() {
        long var1 = 10; // int 형 벙위 내의 숫자는 l 이나 L 을 붙이지 않아도 저장 가능
        long var2 = 20L; // long 형 변수를 초기화 할땐 초기값 뒤에 l 이나 L 을 붙임
        // long var3 = 1000000000000; 컴파일 에러. int 형 범위를 벗어나는 숫자는 꼭 l 이나 L 을 붙여야함
        long var4 = 1000000000000L;

        System.out.println(var1); // 10
        System.out.println(var2); // 20
        System.out.println(var4); // 1000000000000
    }
    public static void example8() {
        double var1 = 3.14; // 실수 타입 기본형
        float var2 = 3.14F; // float 형임을 표현하기 위해 초기값 뒤에 f 나 F 를 붙임

        // double 과 float 의 가수부분의 비트 차이가 약 2배기 때문에
        // 정확하게 출력할 수 있는 범위도 약 2배 차이다.(double: 17자리, float: 9자리)
        double var3 = 0.1234567890123456789;
        float var4 = .1234567890123456789F;

        System.out.println(var1); // 3.14
        System.out.println(var2); // 3.14
        System.out.println(var3); // 0.12345678901234568
        System.out.println(var4); // 0.123456789

        int var5 = 3000000;

        // 정수 리터럴이라도 지수를 표현하는 e 혹은 E 가 있다면 실수형 변수에 저장
        double var6 = 3e6;
        float var7 = 3e6F;
        double var8 = 2e-3;

        System.out.println(var5); // 3000000
        System.out.println(var6); // 3000000.0
        System.out.println(var7); // 3000000.0
        System.out.println(var8); // 0.002
    }
    public static void example9() {
        boolean stop = true; // true, false(논리값) 를 저장할 수 있는 데이터 타입
        if(stop) { System.out.println("중지합니다."); }
        else { System.out.println("시작합니다."); }
    }
    public static void example10() {
        // 형변환(자동 형변환)
        // 작은 크기 타입이 큰 크기 타입에 저장될 때 자동으로 큰 크기 타입으로 형변환
        // 작은 그릇에 있는 물을 큰 그릇으로 옮겨도 물의 양은 그대로 인것과 같은 원리
        // byte -> short -> int -> long -> float -> double (작->큰)
        // 실수형이 정수형보다 표현할 수 있는 수위 범위가 넓어 더 큰 크기 타입으로 정의
        // char 형은 음수를 담을 수 없는데 byte 형이 음수를 담고 있을 수도 있어
        // byte 형이 char 형으로 자동 형변환 되지 않음(예외)

        byte byteValue = 10;
        int intValue = byteValue; // byte -> int
        System.out.println(intValue); // 10

        char charValue = '가';
        intValue = charValue; // char -> int
        System.out.println(intValue); // 44032

        intValue = 500;
        long longValue = intValue; // int -> long
        System.out.println(longValue); // 500

        intValue = 200;
        double doubleValue = intValue; // int -> double
        System.out.println(doubleValue); // 200.0
    }
    public static void example11() {
        // 형변환(강제 형변환(=캐스팅))
        // 큰 크기 타입을 작은 크기 타입으로 저장할 때 강제적 형변환이 필요

        // 큰 크기 정수 -> 작은 크기 정수
        // 뒤에서부터 작은 크기 타입의 바이트 만큼 잘라 저장. 나머지는 버림
        // 수의 손실이 있을 수 있음
        int intValue = 44032;
        char charValue = (char) intValue; // int -> char
        System.out.println(charValue); // 가

        long longValue = 500;
        intValue = (int) longValue; // long -> int
        System.out.println(intValue); // 500

        // 실수 -> 정수
        // 소수점을 버림
        double doubleValue = 3.14;
        intValue = (int) doubleValue; // double -> int
        System.out.println(intValue); // 3
    }
    public static void example12() {
        // 강제 형변환 할 때 중요한 점은 값의 손실이 없어야 하는 점
        // 그렇기 때문에 형변환 하기 전에 최대, 최소 값 사이에 있는 수인지 확인
        int i = 128;

        if(i < Byte.MIN_VALUE || i > Byte.MAX_VALUE) {
            System.out.println("값의 손실이 일어납니다.");
        } else {
            byte b = (byte) i;
            System.out.println(b);
        }
    }
    public static void example13() {
        // 연산 중 자동 형변환
        // 정수의 기본형은 int, 실수의 기본형은 double
        // 따라서 정수 연산 중에 long 형이 없다면 반환형은 int, 실수 리터럴이 있거나 실수 연산에서 반환형은 double

        byte byteValue1 = 10;
        byte byteValue2 = 20;
        int intValue1 = byteValue1 + byteValue2; // byte + byte -> int
        System.out.println(intValue1);

        int intValue = 10;
        double doubleValue = 20.0;
        double result = intValue + doubleValue; // int + double -> double
        System.out.println(result);

        char charValue1 = 'A';
        char charValue2 = 1;
        int intValue2 = charValue1 + charValue2; // char + char -> int
        System.out.println(intValue2);
        System.out.println((char) intValue2);

        int intValue3 = 10;
        int intValue4 = intValue3 / 4; // int / int -> int
        System.out.println(intValue4);

        int intValue5 = 10;
        double doubleVaule = intValue5 / 4.0; // int / 실수 리터럴 -> double
        System.out.println(doubleVaule);
    }
}
