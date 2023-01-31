package Interface;

public class Television implements RemoteControl {
    /*
     인터페이스 구현

     객체는 인터페이스의 추상메서드와 동일한 메서드(메서드 명, 매개변수 타입, 리턴 타입)를 가진 실체 메서드를 가지고 있어야 한다.
     이런 객체를 구현 객체라 하며, 구현 객체를 생성하는 클래스를 구현 클래스라고 한다.
     구현 클래스 -> public class 구현클래스명 implements 인터페이스명 { (필수)인터페이스의 추상메서드에 실행 내용을 적은 실체 메서드 }
     실체 메서드를 작성할 때 주의할 점은 추상메서드보다 강한 제한을 가질수 없으며,
     일부 추상메서드만 실체 메서드를 가질 경우 해당 클래스는 구현 클래스가 아닌 추상 클래스가 된다.
     new 연산자를 통해 구현 객체를 만들수 있는데 이때 인터페이스 타입 변수에 구현 객체를 저장해야 한다.
     */

    private int volume;

    // RemoteControl 인터페이스의 turnOn 추상메서드의 실체 메서드
    @Override
    public void turnOn() {
        System.out.println("tv를 켭니다.");
    }
    // RemoteControl 인터페이스의 turnOff 추상메서드의 실체 메서드
    @Override
    public void turnOff() {
        System.out.println("tv를 끕니다.");
    }
    // RemoteControl 인터페이스의 setVolume 추상메서드의 실체 메서드
    @Override
    public void setVolume(int volume) {
        if(volume>MAX_VOLUME) {
            this.volume = MAX_VOLUME;
        } else if(volume<MIN_VOLUME) {
            this.volume = MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 tv 볼륨 : " + this.volume);
    }
}
