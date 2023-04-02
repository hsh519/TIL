package LV2;

public class 예상_대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while (a != b) {
            a = a % 2 == 1 ? (a+1)/2 : a/2;
            b = b % 2 == 1 ? (b+1)/2 : b/2;
            if (a==b) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
