package LV0;

public class 자릿수_더하기 {
    public int solution(int n) {
        int answer = 0;
        int len = ((Integer.toString(n)).length()-1);
        int num = 1;
        for (int i=0; i<len; i++) {
            num *= 10;
        }
        while (num != 0) {
            answer += n / num;
            n %= num;
            num /= 10;
        }
        return answer;
    }
}
