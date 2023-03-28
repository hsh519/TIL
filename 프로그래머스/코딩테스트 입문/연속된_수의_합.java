import java.util.Arrays;

public class 연속된_수의_합 {
    public int[] solution(int num, int total) {
        int[] standard = new int[num];
        for (int i=0; i < num; i++) {
            standard[i] = i+1;
        }
        int hap = Arrays.stream(standard).sum();
        if (hap != total) {
            int rest = (total - hap) / num;
            for (int i=0; i<standard.length; i++) {
                standard[i] += rest;
            }
        }
        return standard;
    }
}
