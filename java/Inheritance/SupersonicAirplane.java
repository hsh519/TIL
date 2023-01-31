package Inheritance;

public class SupersonicAirplane extends Airplane {
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    // fly 메서드를 오버라이딩하지만 부모클래스의 fly 메서드를 사용해야 할 경우 super 키워드를 사용해 직접 접근
    @Override
    public void fly() {
        if(flyMode == NORMAL) {
            super.fly(); // 부모클래스의 fly 메서드
        } else {
            System.out.println("초음속비행입니다.");
        }

    }
}
