import java.util.Calendar;
public class referenceType {
    public static void main(String[] args) {
        // 커멘드 라인
        // 프로그램을 실행하면 String 타입 args 배열이 생성
        // 이후 main 메서드에 의해 호출되며 매개값으로 전달
        // 프로그램 실행 전 값을 미리 적어놓고 실행하면 main 메서드에게 전달되는 것
        // 전달되는 배열을 통해 배열의 길이와 배열의 값들을 알 수 있는 것

        if(args.length != 2) { // 프로그램을 실행할 때 2개의 값을 주지 않는다면
            System.out.println("프로그램의 사용법");
            System.out.println("java referenceType num1 num2");
            System.exit(0); // 프로그램 종료
        }

        String strNum1 = args[0];
        String strNum2 = args[1];

        // 문자열을 정수로 변환하는 메서드
        // 바꿀수 없는 문자열이라면 NumberFormatException 예외 발생
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);
        int result = num1 + num2;

        System.out.println(num1 + " + " + num2 + " = " + result);

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
    }
    public static void example1() {
        // 문자열
        // 문자열은 참조 타입. 참조 타입 -> 변수에 객체의 주소값이 저장되는 타입
        // 문자열 리터럴이 같을 경우 같은 객체를 참조하기 때문에 같은 주소값을 가짐.
        String strVar1 = "홍석환";
        String strVar2 = "홍석환";

        // == 연산자는 변수값을 비교하기 때문에 문자열을 비교하는 것이 아닌 주소값을 비교
        if(strVar1 == strVar2) {
            System.out.println("참조가 같음");
        } else {
            System.out.println("참조가 다름");
        }

        // 문자열을 비교하고 싶다면 equals 메서드 사용
        if(strVar1.equals(strVar2)) {
            System.out.println("문자열이 같음");
        }

        // new 연산자로 String 객체를 생성할 경우 문자열이 같아도 다른 객체로 인식
        // strVar1,strVar2 와 strVar3 과 strVar4 는 다른 객체를 참조
        String strVar3 = new String("홍석환");
        String strVar4 = new String("홍석환");

        if(strVar3 == strVar4) {
            System.out.println("참조가 같음");
        } else {
            System.out.println("참조가 다름");
        }

        if(strVar3.equals(strVar4)) {
            System.out.println("문자열이 같음");
        }
    }
    public static void example2() {
        // 배열
        // 배열은 같은 타입의 값을 연속된 공간에 나열시키고
        // 각 데이터에 인덱스를 부여한 자료구조
        // 배열도 참조 타입이므로 배열의 0번째 인덱스의 주소값이 변수에 저장
        int[] scores = {82, 90, 87};

        // 인덱스를 사용해 데이터에 접근
        System.out.println("scores[0] : " + scores[0]);
        System.out.println("scores[1] : " + scores[1]);
        System.out.println("scores[2] : " + scores[2]);

        int sum = 0;
        for(int i=0; i<3; i++) {
            sum += scores[i];
        }

        System.out.println("총합 : " + sum);
        double avg = (double) sum / 3;
        System.out.println("평균 : " + avg);
    }
    public static void example3() {
        // 배열을 선언한 후에 값을 대입하는 과정에서
        // 변수 = {값, 값, 값} 형태로 대입 -> X(변수에 베얄 값을 담는 것이 아님)
        // 배열을 참조 타입이므로 객체의 주소값을 담기 때문에 객체를 new 연산자를 사용해
        // 객체를 생성해준 후 주소값을 담도록 해야함
        int[] scores;
        // scores = {83, 90, 87} 에러
        scores = new int[] {83, 90, 87};
        int sum1 = 0;
        for(int i=0;i<3;i++) {
            sum1 += scores[i];
        }
        System.out.println("총합 : " + sum1);

        // int sum2 = add({83, 97, 80}) 에러
        int sum2 = add(new int[] {83, 97, 80});
        System.out.println("총합 : " + sum2);
    }
    public static int add(int[] scores) {
        int sum = 0;

        for(int i=0; i<3; i++) {
            sum += scores[i];
        }
        return sum;
    }
    public static void example4() {
        // 배열을 당장 사용할 것은 아니지만 후에 사용하기 위해 미리 만들고 싶을 때
        // 배열의 길이를 정해 생성
        // new 배열의 타입[배열의 길이]. 배열의 길이만큼 기본값이 저장되있는 형태
        // 타입에 따라서 기본값이 다 다름. 보통 null, 0, false 의 값이 기본값

        // int 타입 배열의 기본값은 0
        int[] arr1 = new int[3];
        for(int i=0; i<3; i++) {
            System.out.println("arr1[" + i+ "] : " + arr1[i]);
        }
        // 배열의 인덱스로 접근해 값을 수정할 수 있음
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        for(int i=0; i<3; i++) {
            System.out.println("arr1[" + i+ "] : " + arr1[i]);
        }

        // double 타입 배열의 기본값은 0.0
        double[] arr2 = new double[3];
        for(int i=0; i<3; i++) {
            System.out.println("arr2[" + i+ "] : " + arr2[i]);
        }
        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;
        for(int i=0; i<3; i++) {
            System.out.println("arr2[" + i+ "] : " + arr2[i]);
        }

        // String 타입 배열의 기본값은 null
        String[] arr3 = new String[3];
        for(int i=0; i<3; i++) {
            System.out.println("arr3[" + i+ "] : " + arr3[i]);
        }
        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";
        for(int i=0; i<3; i++) {
            System.out.println("arr3[" + i+ "] : " + arr3[i]);
        }
    }
    public static void example5() {
        // 배열의 길이를 알고 싶을 땐 배열명.length 를 사용
        // 배열명.length = 4 처럼 사용해서 필드명을 바꿀 수 없음
        // length 는 읽기 전용 필드
        int[] scores = {83, 90, 87};

        int sum = 0;
        for(int i=0; i<scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);

        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg);
    }
    public static void example6() {
        // 2차원 배열
        // 배열 중첩 방식으로 2차원 배열 구현
        // 배열의 타입[배열의 행][배열의 열]
        // 배열 변수가 배열의 행을 참조하며 배열의 행은 각 인덱스 별로 배열의 열을 참조
        // 값을 접근하는 방법은 1차원 배열과 동일
        // ex) {{1,2,3}, {4,5}} 에서 [1][0]
        // 큰 배열 안에서 인덱스1(={4,5}) 값을 찾고 그 안에서 인덱스0(=4) 값을 찾음

        // new int[2][3] -> {{0,0,0}, {0,0,0}}
        int[][] mathScores = new int[2][3];
        for(int i=0; i<mathScores.length; i++) {
            for(int k=0; k<mathScores[i].length; k++) {
                System.out.println("mathScores[" + i + "][" + k + "] = " + mathScores[i][k]);
            }
        }
        System.out.println();

        int[][] englishScores = new int[2][]; // {{}, {}}
        englishScores[0] = new int[2]; // {{0,0}, {}}
        englishScores[1] = new int[3]; // {{0,0}, {0,0,0}}
        for(int i=0; i<englishScores.length; i++) {
            for(int k=0; k<englishScores[i].length; k++) {
                System.out.println("englishScores[" + i + "][" + k + "] = " + englishScores[i][k]);
            }
        }
        System.out.println();

        int[][] javaScores = {{95, 80}, {92, 96, 80}};
        for(int i=0; i<javaScores.length; i++) {
            for(int k=0; k<javaScores[i].length; k++) {
                System.out.println("javaScores[" + i + "][" + k + "] = " + javaScores[i][k]);
            }
        }
    }
    public static void example7() {
        // String 배열
        // String 변수와 동일하게 취급(== 연산자는 주소값 비교, equals 메서드는 문자열 비교)
        // 따라서 배열의 이름[인덱스]에 들어가는 값은 문자열 리터럴이 아닌 객체의 주소값

        String[] strArray = new String[3]; // {null, null, null}
        strArray[0] = "Java"; // {"Java"의 주소값, null, null}
        strArray[1] = "Java"; // {"Java"의 주소값, "Java"의 주소값, null}
        strArray[2] = new String("Java"); // {"Java"의 주소값, "Java"의 주소값, 새로운 "Java"의 주소값}

        System.out.println(strArray[0] == strArray[1]);
        System.out.println(strArray[1] == strArray[2]);
        System.out.println(strArray[0].equals(strArray[2]));
    }
    public static void example8() {
        // 배열은 한번 생성하면 크기 변경 불가. 따라서 다른 배열에 복사해야 함
        // for 문을 이용해 배열을 복사하는 방법
        // 배열의 길이를 정해 생성한 후 그 배열에 하나씩 복사
        // 복사를 다 하고 남는 애들은 기본값으로 유지

        int[] oldIntArray = {1,2,3};
        int[] newIntArray = new int[5]; // {0,0,0,0,0}

        // {0,0,0,0,0} -> {1,2,3,0,0}
        for(int i=0; i<oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }

        for(int i=0; i<newIntArray.length; i++) {
            System.out.println(newIntArray[i] + " , ");
        }
    }
    public static void example9() {
        // arraycopy 메서드를 이용한 방법
        // System.arraycopy(원본 배열, 복사를 시작할 인덱스, 새 배열, 붙여넣기를 시작할 인덱스, 복사할 요소 개수)

        String[] oldStrArray = {"java", "array", "copy"};
        String[] newStrArray = new String[5];

        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);

        for(int i=0; i<newStrArray.length; i++) {
            System.out.println(newStrArray[i] + " , ");
        }
    }
    public static void example10() {
        // 향상된 for 문
        // 카운터 변수와 증감식을 사용하지 않음
        // 요소를 하나씩 꺼내 실행문을 실행. 꺼내올 요소가 없으면 반복문 종료
        // 요소의 개수만큼 반복
        int[] scores = {95, 71, 84, 93, 87};

        int sum = 0;
        // score 변수에 들어가는 값 -> 95, 71, 84, 93, 87
        for(int score : scores) {
            sum += score;
        }
        System.out.println("총합 : " + sum);

        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg);
    }
    public static void example11() {
        // 열거 타입
        // 한정된 값만 갖는 데이터 타입(요일, 계절 등등)
        // 몇 개의 열거 상수 중 하나의 상수를 저장하는 데이터 타입
        // 열거 타입을 선언하면 메소드 영역에 열거 상수들이
        // 힙 영억에 있는 해당 열거 객체를 각각 참조
        // 열거 객체 == 선택한 열거 상수

        // 열거 타입은 참조 타입이기 때문에 어느 객체도 참조하지 않겠다는 null 가능
        Week today = null;

        // Calendar
        // Calendar.getInstance 메서드로 현재 날짜 정보를 Calendar 객체롤 리턴 받음
        // 오늘의 요일에 대한 정수값(Calendar.DAY_OF_WEEK)을
        // Calendar 객체(cal)에서 get 메서드를 이용해 가져옴
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);

        // 힙 영역에 있는 열거 객체의 주소값을 열거 타입 변수 today 에 저장
        // 즉, 하나의 열거 상수만이 열거 타입 변수에 저장
        switch(week) {
            case 1:
                today = Week.SUNDAY;
                break;
            case 2:
                today = Week.MONDAY;
                break;
            case 3:
                today = Week.TUESDAY;
                break;
            case 4:
                today = Week.WEDNESDAY;
                break;
            case 5:
                today = Week.THURSDAY;
                break;
            case 6:
                today = Week.FRIDAY;
                break;
            case 7:
                today = Week.SATURDAY;
                break;
        }
        System.out.println("오늘 요일 : " + today );

        // 메소드 영역에 있는 Week 열거 타입의 SUNDAY 열거 상수에 있는 주소값과
        // today 에 있는 주소값 비교
        if(today == Week.SUNDAY) {
            System.out.println("알요일에는 쉽니다.");
        } else {
            System.out.println("전공 공부 합니다.");
        }
    }
    public static void example12() {
        // 열거 객체는 열거 상수 문자열과 메서드들을 가지고 있음
        // 모든 열거 타입은 컴파일 시 Enum 클래스를 상속하도록 되어 있음
        // 따라서 name, ordinal, compareTo, valueOf, values 메서드를
        // 따로 추가하지 않아도 사용할 수 있음

        // name 메서드
        // 열거 객체가 가지고 있는 열거 상수 문자열을 리턴
        Week today = Week.SUNDAY;
        String name = today.name();
        System.out.println(name); // SUNDAY

        // ordinal 메서드
        // 열거 객체의 순번을 알려줌
        // 열거 상수를 선언한 순서대로 순번이 지정. 순번은 0부터 시작
        int ordinal = today.ordinal();
        System.out.println(ordinal); // 6

        // comepareTo 메서드
        // 매개값으로 주어진 열거 객체를 기준으로 몇 번째 위치하는지 알려줌
        // 매개값보다 앞순번이면 음수, 뒷순번이면 양수
        Week day1 = Week.MONDAY;
        Week day2 = Week.WEDNESDAY;
        int result1 = day1.compareTo(day2);
        int result2 = day2.compareTo(day1);
        System.out.println(result1); // -2
        System.out.println(result2); // 2

        // valueOf 메서드
        // 문자열과 동일한 열거 상수 문자열을 가진 열거 객체를 리턴
        String strDay = "THURSDAY";
        Week weekDay = Week.valueOf(strDay); // Week.THURSDAY
        if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
            System.out.println("주말");
        } else {
            System.out.println("평일");
        }

        // values 메서드
        // 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴
        Week[] days = Week.values(); // {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
        for(Week day : days) {
            System.out.println(day);
        }
    }
}
