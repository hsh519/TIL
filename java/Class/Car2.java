package Class;

public class Car2 {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    int speed;
    int getSpeed() {
        return speed;
    }
    void setSpeed(int speed) {
        this.speed = speed;
    }
    void keyTurnOn() {
        System.out.println("키를 돌립니다.");
    }
    void run() {
        for(int i=10; i<=50; i+=10) {
            speed = i;
            System.out.println(this.model + "가(이) 달립니다.(시속: "+speed+"km/h)");
        }
    }
    Car2() {
        this("트럭", "파란색", 100);
    }
    Car2(String model) {
        this(model, "은색", 250);
    }
    Car2(String model, String color) {
        this(model, color, 250);
    }
    Car2(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
