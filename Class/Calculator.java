package Class;

public class Calculator {
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }
    int plus(int x, int y) {
        int result = x + y;
        return result;
    }
    double avg(int x, int y) {
        double sum = plus(x, y); // 클래스 나부에서 plus 메서드 호출
        double result = sum / 2;
        return result;
    }
    void execute() {
        double result = avg(10,7); // 클래스 내부에서 avg 메서드 호출
        println("실행결과: " + result); // 클래스 내부에서 println 메서드 호애
    }
    void println(String message) {
        System.out.println(message);
    }
    double divide(int x, int y) {
        double result = (double) x / (double) y;
        return result;
    }
    double areaRectangle(double width) {
        return width * width;
    }
    double areaRectangle(double width, double height) {
        return width * height;
    }
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }
    int sum1(int[] value) {
        int sum = 0;
        for(int i=0; i<value.length; i++) {
            sum += value[i];
        }
        return sum;
    }
    int sum2(int ... values) {
        int sum = 0;
        for(int i=0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
