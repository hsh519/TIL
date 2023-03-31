package LV2;

import java.util.Arrays;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            int cnt = (int) Arrays.stream(s.split("")).filter(m -> m.equals("1")).count();
            answer[0] += 1;
            answer[1] += s.length() - cnt;
            s = Integer.toBinaryString(cnt);
        }
        return answer;
    }
}
