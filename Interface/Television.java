package Interface;

public class Television implements RemoteControl {
    // 인터페이스 구현

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
