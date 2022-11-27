package Class;

public class Calculator {
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    double divide(int x, int y) {
        double result = (double) x / (double) y;
        return result;
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
