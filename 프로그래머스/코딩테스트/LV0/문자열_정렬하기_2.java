package LV0;

import java.util.Arrays;

public class 문자열_정렬하기_2 {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        char[] c = my_string.toCharArray();
        Arrays.sort(c);
        answer = new String(c);

        return answer;
    }
}
