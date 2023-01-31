public class operator {
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
        example14();
        example15();
        example16();
        example17();
        example18();
    }
    public static void example1() {
        // 부호 연산자(양수, 음수 표시하는 것이 아님)
        // + : 부호 변화 X, - : 부호 변화 O
        int x = -100;
        int result1 = +x; // -100
        int result2 = -x; // 100
        System.out.println(result1);
        System.out.println(result2);

        // 부호 연산자의 산출값은 숫자. 숫자의 기본형은 int
        // 따라서 int 형 변수에 저장할 수 있음
        short s = 100;
        // short result3 = -s; 컴파일 에러
        int result3 = -s;
        System.out.println(result3);
        System.out.println();
    }
    public static void example2() {
        // 증감 연산자
        // ++ : 1을 증가시킴, -- : 1을 감소시킴
        // x = x+1 과 x++ 은 동일한 바이트 코드가 생성되기 때문에 연산 속도를 비교 할 수 없음
        int x = 10;
        int y = 10;
        int z;

        // 증감 연산자 혼자 있을 때는 앞, 뒤 상관없음
        x++;
        ++x;
        System.out.println(x); // 12

        y--;
        --y;
        System.out.println(y); // 8

        // 다른 연산자와 같이 있을 때는 다름
        // 변수++ : 다른 연산을 마친 후 1을 증가,++변수 : 1을 증가시킨 후 다른 연산 수행
        z = x++;
        System.out.println(z); // 12
        System.out.println(x); // 13

        z = ++x;
        System.out.println(z); // 14
        System.out.println(x); // 14

        z = ++x + y++;
        System.out.println(z); // 23
        System.out.println(x); // 15
        System.out.println(y); // 9
        System.out.println();
    }
    public static void example3() {
        // 논리 부정 연산자
        // true 를 false 로, false 를 true 로 변경
        boolean play = true;
        System.out.println(play);

        play = !play; // false
        System.out.println(play);

        play = !play; // true
        System.out.println(play);
    }
    public static void example4() {
        // 비트 연산자
        // 10진수의 정수를 2진수로 표현한 후 부호 비트를 포함해 0 을 1로, 1을 0으로 바꿈.
        // 산출 값은 숫자, 숫자의 기본형은 int 이므로 int 형 변수에 저장해야함
        // 비트연산을 한 숫자에 1을 더하면 원래 숫자의 반대값(음->양, 양->음)이 나옴
        int v1 = 10;
        int v2 = ~v1;
        int v3 = ~v1 + 1;
        System.out.println(toBinaryString(v1));
        System.out.println(toBinaryString(v2));
        System.out.println(toBinaryString(v3));
        System.out.println();

        int v4 = -10;
        int v5 = ~v4;
        int v6 = ~v4 + 1;
        System.out.println(toBinaryString(v4));
        System.out.println(toBinaryString(v5));
        System.out.println(toBinaryString(v6));
        System.out.println();
    }
    public static String toBinaryString(int value) {
        // Integer.toBinaryString(v) 메서드
        // v를 32비트의 이진 문자열로 리턴하는 메서드
        // 앞에 있는 의미없는 0은 생략하므로 문자열 길이가 32보다 작으면 앞에 0을 붙여주는 메서드를 따로 구현해야함
        String str = Integer.toBinaryString(value);

        while(str.length() < 32) {
            str = "0" + str;
        }
        return str;
    }
    public static void example5() {
        // 산술 연산자
        // 가감승제 + 나머지 연산자(나눈 나머지를 반환함)
        // 피연산자의 타입이 다를 경우
        // 1. 피연산자 모두 정수 타입(모두 리터럴일 경우 제외)일 경우 산출 타입은 int 로 맞춤
        // 2. 피연산자 중 long 타입이 있을 경우 산출 타입은 long 으로 맞춤
        // 3. 피연산자 중 실수가 있을 경우 산출 타입은 실수형(float, double)으로 맞춤
        int v1 = 5;
        int v2 = 2;

        int result1 = v1 + v2;
        System.out.println(result1); // 7

        int result2 = v1 - v2;
        System.out.println(result2); // 3

        int result3 = v1 * v2;
        System.out.println(result3); // 10

        // v1 과 v2 둘 다 정수이므로 산출타입은 int 이다.
        // 나눈 결과에서 소수점 이하 버리고 몫을 계산 결과로 반환
        int result4 = v1 / v2;
        System.out.println(result4); // 2

        // 나눈 결과에서 몫을 버리고 나머지를 계산 결과로 반환
        int result5 = v1 % v2;
        System.out.println(result5); // 1

        // v1 을 강제 형변환 해 double 로 되었기 때문에 산출 타입은 double
        // 나눈 결과 그대로를 반환
        double result6 = (double)v1 / v2;
        System.out.println(result6); // 2.5
        System.out.println();
    }
    public static void example6() {
        // char 타입도 정수 타입이므로 산술 연산이 가능하며 산출 타입은 int
        char c1 = 'A' + 1; // 리터럴 간의 연산은 해당 타입으로 계산하기 때문에 문제 없음
        char c2 = 'A';
        // c2 가 정수 타입이기 때문에 int 타입으로 형변환 후 연산됨
        // 산출 타입이 int 가 아닌 char 이라서 컴파일 에러
        // c2 + 1 의 결과를 char 타입으로 강제 형변환 하면 해결
        // char c3 = c2 + 1;
        char c3 = (char) (c2 + 1);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println();
    }
    public static void example7() {
        // 오버플로우(최대값 보다 큰 수를 할당할 경우)
        // 타입 범위에 벗어나는 수가 저장될 경우 쓰레기값이 저장됨
        // 1000000000000가 2147483647보다 크므로 int 타입이 저장할 수 있는 수의 범위를 벗어남
        // 피연산자 중 최소 하나는 long 타입으로 바꾸고, 값을 저장하는 변수 또한 long 타입으로 바꿈
        // int x = 1000000
        // int y = 1000000
        // int z = x * y
        long x = 1000000;
        long y = 1000000;
        long z = x * y;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(z);
        System.out.println();
    }
    public static void example8() {
        // 보통 리터럴로 직접 주는 경우보다 사용자가 입력하는 경우가 많음
        // 따라서 산술 연산을 하기 전에 오버플로우를 확인해주는 메서드를 이용하는 것이 좋음
        // 예외처리를 사용해 만든 safeAdd() 메서드
        try {
            int result = safeAdd(2000000000, 2000000000);
            System.out.println(result);
            System.out.println();
        } catch(ArithmeticException e) {
            System.out.println("오버플로우 발생");
            System.out.println();
        }
    }
    public static int safeAdd(int num1, int num2) {
        if(num1 >= 0) {
            if(num2 > Integer.MAX_VALUE - num1) {
                throw new ArithmeticException("오버플로우 발생");
            }
        } else {
            if(num2 < Integer.MIN_VALUE - num1) {
                throw new ArithmeticException("오버플로우 발생");
            }
        }
        return num1 + num2;
    }
    public static void example9() {
        // 부동 소수점의 근사치 처리 때문에 정확한 값을 도출할 수 없음
        // 정확한 계산을 위해선 정수 연산을 한 후 실수형으로 변경해야 함
        // int apple = 1
        // double pieceUnit = 0.1
        // int number = 7
        // double result = apple - number * pieceUnit

        int apple = 10;
        int number = 7;
        int restPiece = apple - number;

        double result = restPiece / 10.0;
        System.out.println(result);
        System.out.println();
    }
    public static void example10() {
        // 실수 타입을 0.0이나 0.0f로 나누면 Infinity, 나머지 연산을 하면 NaN이 나옴
        // 이 결과는 어떤 연산을 해도 Infinity, NaN가 나오기 때문에 값이 망가지므로 확인 작업이 필요
        // 확인 할 때 == 연산자를 사용하면 연산식 상관없이 false 를 반환하기 때문에 == 연산자 사용하면 안됨
        int x = 5;
        double y = 0.0;

        // Double.isInfinite() 메서드로 Infinity 여부 확인 가능
        double z = x / y;
        System.out.println(Double.isInfinite(z));
        System.out.println(z + 2); // Infinity

        // Double.isNaN() 메서드로 NaN 여부 확인 가능
        z = x % y;
        System.out.println(Double.isNaN(z));
        System.out.println(z + 2); // NaN
        System.out.println();
    }
    public static void example11() {
        // 문자열 연결 연산자
        // 피연산자 중 하나가 문자열이면 다른 하나도 문자열로 형변환되어 연결 연산을 수행
        String str1 = "JDK" + 6.0;
        String str2 = str1 + "특징";
        System.out.println(str2);

        // + 연산자는 왼쪽에서 오른쪽으로 연산이 수행됨. 따라서 순서에 따라 결과가 달라질 수 있음
        String str3 = "JDK" + 3 + 3.0; // JDK33.0
        String str4 = 3 + 3.0 + "JDK"; // 6.0JDK
        System.out.println(str3);
        System.out.println(str4);
    }
    public static void example12() {
        // 비교 연산자
        // 피연산자를 비교해 true, false 중 하나를 반환
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println(result1); // true
        System.out.println(result2); // false
        System.out.println(result3); // true

        // char 타입은 유니코드 값으로 두 피연산자를 비교
        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = char1 < char2;
        System.out.println(result4); // true
        System.out.println();
    }
    public static void example13() {
        // 문자열 비교
        // 문자열은 타입이 아닌 객체
        // 따라서 문자열 변수는 문자열 값이 아닌 String 객체가 저장된 번지값이 저장
        // == 연산자는 번지값을 비교하기 때문에 문자열이 같아도 번지값이 다르면 false 를 반환
        // 문자열만을 비교하고 싶다면 equals 메서드를 사용

        // 리터럴이 동일하다면 동일한 String 객체를 참조
        // new String 으로 객체를 생성하면 새 String 객체를 참조
        // 세 변수 모두 문자열 값은 같지만, strVar1 strVar2 와 strVar3 의 번지값은 다름
        String strVar1 = "홍석환";
        String strVar2 = "홍석환";
        String strVar3 = new String("홍석환");

        System.out.println(strVar1 == strVar2); // true
        System.out.println(strVar2 == strVar3); // false
        System.out.println();
        System.out.println(strVar1.equals(strVar2)); // true
        System.out.println(strVar2.equals(strVar3)); // true
        System.out.println();
    }
    public static void example14() {
        // 논리 연산자
        // &,&& 둘다 true -> true
        // |,|| 둘 중 하나라도 true -> true
        // ^ 하나는 true, 다른 하나는 false -> true
        // ! 논리값을 바꿈
        int charCode = 'A';
        int value = 6;

        // & 는 피연산자 둘다 확인 후 산출 결과를 냄
        if((charCode >= 65) & (charCode <= 90)) {
            System.out.println("대문자");
        }

        // && 는 앞 조건이 false 면 뒷 조건은 확인하지 않고 false 결과를 냄
        // & 보다 효율이 좋음
        if((charCode >= 97) && (charCode <=122)) {
            System.out.println("소문자");
        }

        if(!(charCode < 48) && !(charCode > 57)) {
            System.out.println("0~9 숫자 이군요");
        }

        // | 는 피연산자 둘다 확인 후 산출 결과를 냄
        if((value % 2 ==0) | (value % 3 == 0)) {
            System.out.println("2의 배수 혹은 3의 배수");
        }

        // || 는 앞 조건이 true 면 뒷 조건은 확인하지 않고 true 결과를 냄
        // | 보다 효율이 좋음
        if((value % 2 ==0) || (value % 3 == 0)) {
            System.out.println("2의 배수 혹은 3의 배수");
        }
    }
    public static void example15() {
        // 비트 논리 연산자(산출 타입은 int)
        // 정수를 2진수로 표현 true, false 대신 1,0 을 이용해 연산
        // & 둘다 1이면 true
        // | 둘중 하나라도 1이면 true
        // ^ 하나는 1, 하나는 0이면 true
        // ~ 모든 비트를 바꿈
        System.out.println();
        System.out.println(45 & 25);
        System.out.println(45 | 25);
        System.out.println(45 ^ 25);
        System.out.println(~45);
        System.out.println();
    }
    public static void example16() {
        // 비트 이동 연산자
        // 정수를 2진수로 표현 후 비트 이동
        // << n 비트를 왼쪽으로 n번 이동. 빈자리는 0으로 채움
        // >> n 비트를 오른쪽으로 n번 이동. 빈자리는 최상위 부호 비트로 채움
        // >>> n 비트를 오른쪽으로 n번 이동. 빈자리는 0으로 채움
        System.out.println(1 << 3);
        System.out.println(-8 >> 3);
        System.out.println(-8 >>> 3);
        System.out.println();
    }
    public static void example17() {
        // 대입 연산자와 복합 대입 연산자
        // =(대입 연산자) 우변에 있는 리터럴 혹은 변수에 저장된 값을 좌변에 있는 변수에 저장하는 연산자
        // 연산자+대입 연산자 => 복합 대입 연산자 (+=, -=, *=, /=, %=...)
        // ex) r += 1 -> r = r + 1
        int result = 0;
        result += 10;
        System.out.println(result); // 10
        result -= 5;
        System.out.println(result); // 5
        result *= 3;
        System.out.println(result); // 15
        result /= 5;
        System.out.println(result); // 3
        result %= 3;
        System.out.println(result); // 0
        System.out.println();
    }
    public static void example18() {
        // 삼항 연산자
        // 조건식 ? true 일 경우 : false 일 경우
        int score = 85;
        char grade = (score > 90) ? 'A' : 'B';
        System.out.println(grade);
    }
}
