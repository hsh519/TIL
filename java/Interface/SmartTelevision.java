package Interface;

// RemoteControl, Searchable 인터페이스를 가진 SmartTelevision 구현클래스
public class SmartTelevision implements RemoteControl, Searchable {
    /*
     다중 인터페이스 구현

     구현 객체는 다수의 인터페이스를 가질 수 있다.
     단, 구현 객체가 가지는 모든 인터페이스의 추상 메서드에 대한 실체 메서드를 작성해야 한다.
     */

    private int volume;
    private String url;

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

    // Searchable 인터페이스의 search 추상메서드의 실체 메서드
    @Override
    public void search(String url) {
        this.url = url;
        System.out.println(this.url + "을 검색합니다.");
    }
}
