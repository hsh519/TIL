package Interface;

public interface RemoteControl {
    /*
     인터페이스 선언
    public interface 인터페이스명 { 상수 필드, 추상 메서드, 디폴트 메서드, 정적 메서드 }
    인터페이스로 객체를 만들 수 없기 때문에 생성자는 없다.

    상수 필드 - 인터페이스는 객체 사용 설명서기 때문에 변수 필드를 선언할 수 없다.
    대신 상수 필드는 선언할 수 있으며 반드시 초기화가 필요하다. public static final 을 생략해도 된다.

    추상 메서드 - 실행 내용을 채우는 {} 가 없는 선언부만 존재하는 메서드.
    구현 클래스에서 반드시 실행 내용을 작성해야 한다. public abstract 을 생략해도 된다.

    디폴트 메서드 - 이미 구현이 되있지만 객체가 생성됐을 때 사용할 수 있는 메서드.
    default 가 앞에 붙으며 public 을 생락해도 된다.

    정적 메서드 - 객체 생성이 없어도 사용할 수 있는 메서드. static 이 앞에 붙으며 public 을 생략해도 된다.
    */

    // 상수 필드
    public int MAX_VOLUME = 10;
    public int MIN_VOLUME = 0;

    // 추상 메서드
    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);

    // 디폴트 메서드
    default void setMute(boolean mute) {
        if(mute) { System.out.println("무음 처리합니다."); }
        else { System.out.println("무음 해제합니다.");}
    }

    // 정적 메서드
    static void changeBattery() {
        System.out.println("건전지를 교환합니다.");
    }
}
