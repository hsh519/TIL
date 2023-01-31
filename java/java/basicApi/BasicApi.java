package basicApi;

import java.util.HashMap;
// java.long 에 Object 클래스를 상속받은 Objects 클래스
import java.util.Objects;

public class BasicApi {
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
    }
    static void example1() {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("yellow");

        if(obj1.equals(obj2)) { // 오버라이딩한 equals 메서드 -> 멤버 객체의 equals 메서드를 호출했기 때문
           System.out.println("obj1 obj2의 동등합니다.");
        } else {
            System.out.println("obj1 obj2의 동등하지 않습니다.");
        }

        if(obj1.equals(obj3)) {
            System.out.println("obj1 obj3의 동등합니다.");
        } else {
            System.out.println("obj1 obj3의 동등하지 않습니다.");
        }
    }
    static void example2() {
        System.out.println();

        HashMap<Key, String> hashMap = new HashMap<Key, String>();

        hashMap.put(new Key(1), "홍석환");
        // 원래 hashCode 메서드라면 리턴하는 해시코드가 다르기 때문에 다른 객체로 인식해 null (hashCode 메서드 -> equals 메서드 -> 동등 객체)
        // 재정의한 hashCode 메서드는 number 필드값을 리턴하기 때문에 필드값만 같으면 같은 객체로 인식
        String value = hashMap.get(new Key(1));
        System.out.println("value = " + value);
    }
    static void example3() {
        System.out.println();

        SmartPhone smartPhone = new SmartPhone("google", "Android");

        String strObj = smartPhone.toString();
        System.out.println("strObj = " + strObj);
        System.out.println(smartPhone); // System.out.println 메서드는 기본 타입이 매개값이면 그대로 출력, 객체가 매개값이면 객체의 toString 메서드 리턴값 출력
    }
    static void example4() {
        System.out.println();

        CloneMember original = new CloneMember("blue", "홍석환", "pw0519", 24, true);

        CloneMember cloned = original.getCloneMember();
        cloned.password = "0519pw";

        System.out.println("[복제 객체의 필드값]");
        System.out.println(cloned);
        System.out.println();
        System.out.println("[원본 객체의 필드값]");
        System.out.println(original);
    }
    static void example5() {
        System.out.println();

        DeepCloneMember original = new DeepCloneMember("홍석환", 24, new int[] {90, 90}, new Car("소나타"));

        DeepCloneMember cloned = original.getMember();
        cloned.scores[0] = 100;
        cloned.car.model = "그랜저";

        // 값을 변경해도 원본 객체는 변함이 없음을 확인
        System.out.println("[복제 객체의 필드값]");
        System.out.println("cloned = " + cloned);
        System.out.println();
        System.out.println("[원본 객체의 필드값]");
        System.out.println("original = " + original);
    }

    static void example6() {
        System.out.println();

        Student student1 = new Student(1);
        Student student2 = new Student(1);
        Student student3 = new Student(2);

        // compare(비교 객체1, 비교 객체2, 비교할때 사용할 comparator 객체)
        int res = Objects.compare(student1, student2, new StudentComparator());
        System.out.println("res = " + res);
        res = Objects.compare(student1, student3, new StudentComparator());
        System.out.println("res = " + res);
    }

    static void example7() {
        System.out.println();

        int o1 = 1000;
        int o2 = 1000;
        System.out.println(Objects.equals(o1, o2));
        System.out.println(Objects.equals(o1, null));
        System.out.println(Objects.equals(null, o2));
        System.out.println(Objects.equals(null, null));
        System.out.println();

        int[] arr1 = {1,2};
        int[] arr2 = {1,2};
        System.out.println(Objects.deepEquals(1, 1));
        System.out.println(Objects.deepEquals(arr1, arr2));
        System.out.println(Objects.deepEquals(arr1, null));
        System.out.println(Objects.deepEquals(null, arr2));
        System.out.println(Objects.deepEquals(null, null));
    }

    static void example8() {
        System.out.println();

        Student student1 = new Student(1, "홍석환");
        Student student2 = new Student(1, "홍석환");
        System.out.println(student1.hashCode()); // student1 객체의 재정의한 hashCode 메서드 호출
        // Objects.hashCode 가 student2 객체의 hashCode 메서드를 호출.
        // 이때 student2 객체에는 재정의한 hashCode 메서드가 있기 때문에 재정의 메서드 호출
        // student1, student2 의 필드값이 결국 두 해시코드는 같다
        System.out.println(Objects.hashCode(student2));
    }

    static void example9() {
        System.out.println();

        String str1 = "홍석환";
        String str2 = null;

        // not null -> 객체 반환, null -> NullPointerException 예외 발생
        System.out.println(Objects.requireNonNull(str1));

        try {
            String name = Objects.requireNonNull(str2);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            String name = Objects.requireNonNull(str2, "이름이 없습니다."); // 두번쨰 매개값은 예외 메세지
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            String name = Objects.requireNonNull(str2, ()->"이름이 없어요 없어!!"); // 람다식으로 예외 메세지 설정
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    static void example10() {
        System.out.println();

        String str1 = "홍석환";
        String str2 = null;
        // Object.toString 메서드는 not null -> 객체 반환, null -> "null"
        // 객체가 매개값이면 객체의 toString 메서드를 호출하는데 String 이 Object 의 toString 메서드를 재정의해 사용하고 있어 '클래스명@16진수해시코드' 가 아닌 객체가 반환된다
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(Objects.toString(str2, "이름이 없습니다.")); // 두번째 매개값은 null 일 때 반환할 문자열
    }
}
