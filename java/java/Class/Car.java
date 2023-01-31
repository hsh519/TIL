package Class;

public class Car {
    String company = "현대자동차";
    String model = "그랜저";
    String color = "검정";
    int maxSpeed = 350;
    int speed;
    int gas;
    private int currentSpeed;
    private boolean stop;
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        if(currentSpeed < 0) {
            this.currentSpeed = 0;
            return;
        }
        this.currentSpeed = currentSpeed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        this.currentSpeed = 0;
    }
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
