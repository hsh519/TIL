public class operator {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
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

}
