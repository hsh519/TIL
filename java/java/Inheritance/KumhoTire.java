package Inheritance;

public class KumhoTire extends Tire{
    public KumhoTire(String location, int maxRotation) {
        super(location, maxRotation);
    }

    // 부모 타입으로 자동 타입 변환되면 부모클래스 필드, 메서드를 접근해야 하지만
    // 오버라이딩 메서드 같은 경우는 자식클래스 메서드가 호출된다.
    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if(accumulatedRotation < maxRotation) {
            System.out.println(location + " KumhoTire 수명 : " + (maxRotation-accumulatedRotation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "KumhoTire 펑크 ***");
            return false;
        }
    }
}
