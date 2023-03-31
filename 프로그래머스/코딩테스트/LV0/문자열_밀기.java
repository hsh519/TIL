package LV0;

import java.util.ArrayList;

public class 문자열_밀기 {
    public int solution(String A, String B) {
        int answer = 0;
        if (A.equals(B)) {
            return 0;
        }
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(A.length() - 1);
            A = A.substring(0, A.length() - 1);
            A = c + A;
            answer += 1;
            if (A.equals(B)) {
                break;
            }
            if (i == A.length() - 1) {
                answer = -1;
            }
        }
        return answer;
    }
}
