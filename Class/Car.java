package Class;

public class Car {
    String company = "현대자동차";
    String model = "그랜저";
    String color = "검정";
    int maxSpeed = 350;
    int speed;
    int gas;
    void setGas(int gas) {
        this.gas = gas;
    }
    boolean isLeftGas() {
        if(gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        } else {
            System.out.println("gas가 있습니다.");
            return true;
        }
    }
    void run() {
        while(true) {
            if(gas > 0) {
                System.out.println("달립니다.(gas잔량:"+gas+")");
                gas -= 1;
            } else {
                System.out.println("멈춥니다.(gas잔량:"+gas+")");
                return;
            }
        }
    }
}
