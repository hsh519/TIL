package LV2;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int maxNum = Arrays.stream(arr).mapToInt(Integer::parseInt).max().getAsInt();
        int minNum = Arrays.stream(arr).mapToInt(Integer::parseInt).min().getAsInt();
        return Integer.toString(minNum) + " " + Integer.toString(maxNum);
    }
}
