package Interface;

public class Car {
    /*
    // 인터페이스 배열로 객체 관리 하기 전 코드
    Tire frontLeftTire = new HankookTire();
    Tire frontRightTire = new HankookTire();
    Tire backLeftTire = new HankookTire();
    Tire backRightTire = new HankookTire();
     */

    // 인터페이스 배열로 객채 관리
    Tire[] tires = {
            new HankookTire(),
            new HankookTire(),
            new HankookTire(),
            new HankookTire()
    };

/*
// 인터페이스 배열로 객체 관리 하기 전 코드
    public void run() {
        frontLeftTire.roll();
        frontRightTire.roll();
        backLeftTire.roll();
        backRightTire.roll();
    }
 */

    // 인터페이스 배열로 객채 관리
    public void run() {
        for(Tire tire : tires) {
            tire.roll();
        }
    }

}
