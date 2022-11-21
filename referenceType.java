public class referenceType {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
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
}
