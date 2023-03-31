package LV0;

import java.util.Arrays;

public class 약수_구하기 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            answer[i] = i+1;
        }
        return Arrays.stream(answer).filter(m -> n % m == 0).toArray();
    }
}
