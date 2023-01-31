package Inheritance;

public class Car {
    // 배열로 객체 관리
    public int speed;

    // 동일한 타입의 값들을 하나의 배열로 관리해 코드 가독성을 높여준다.
    Tire[] tires = {
            new Tire("앞왼쪽", 6),
            new Tire("앞오른쪽", 2),
            new Tire("뒤왼쪽", 3),
            new Tire("뒤오른쪽", 4)
    };
    /*
    // 하나의 배열로 관리하기 전 코드
    Tire frontLeftTire = new Tire("앞왼쪽", 6);
    Tire frontRightTire = new Tire("앞오른쪽", 2);
    Tire backLeftTire = new Tire("뒤왼쪽", 3);
    Tire backRightTire = new Tire("뒤오른쪽", 4);
    */

    int run() {
        // 배열로 관리했을 때의 코드
        System.out.println("[자동차가 달립니다.]");
        for(int i=0; i<tires.length; i++) {
            if(tires[i].roll() == false) {stop(); return i+1;}
        }
        /*
        // 하나의 배열로 관리하기 전 코드
        if(frontLeftTire.roll() == false) {stop(); return 1;}
        if(frontRightTire.roll() == false) {stop(); return 2;}
        if(backLeftTire.roll() == false) {stop(); return 3;}
        if(backRightTire.roll() == false) {stop(); return 4;}
         */
        return 0;
    }

    public void speedUp() {
        speed += 1;
    }

    public final void stop() {
        System.out.println("[자동차가 멈춥니다]");
        speed = 0;
    }
}
