package LV2;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 1;
        for (int i=1; i<n; i++) {
            int count = i;
            for (int j=i+1; j<n+1; j++) {
                count += j;
                if (count == n) {
                    answer += 1;
                    break;
                } else if (count > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
