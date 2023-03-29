import java.util.Arrays;

public class 배열의_유사도 {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (int i=0; i<s1.length; i++) {
            if (Arrays.asList(s2).contains(s1[i])) {
                answer += 1;
            }
        }
        return answer;
    }
}
