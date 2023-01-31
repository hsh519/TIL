package Inheritance;

public class DmbCellPhone extends CellPhone {
    int channel;
    DmbCellPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }
    void turnOnDmb() {
     System.out.println("채녈 " + channel + "번");
    }
    void changeChannelDmb(int changeChannel) {
        this.channel = changeChannel;
        System.out.println("채녈 " + changeChannel + "번으로 바꿉니다.");
    }
    void turnOffDmb() {
        System.out.println("DMB 방송 수신을 멈춥니다.");
    }
}
