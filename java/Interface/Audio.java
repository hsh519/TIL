package Interface;

public class Audio implements RemoteControl{
    // 인터페이스 구현

    private int volume;

    // RemoteControl 인터페이스의 turnOn 추상메서드의 실체 메서드
    @Override
    public void turnOn() {
        System.out.println("audio를 켭니다.");
    }
    // RemoteControl 인터페이스의 turnOff 추상메서드의 실체 메서드
    @Override
    public void turnOff() {
        System.out.println("audio를 끕니다.");
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
        System.out.println("현재 audio 볼륨 : " + this.volume);
    }

    // 디폴트 메서드 오버라이딩
    @Override
    public void setMute(boolean mute) {
        if(mute) {
            System.out.println("audio 무음 처리합니다.");
        } else {
            System.out.println("audio 무음 해제합니다.");
        }
    }
}
