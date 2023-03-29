public class 제곱수_판별하기 {
    public int solution(int n) {
        int answer = 2;
        for (int i=1; i<n; i++) {
            if(n / i == i) {
                answer = n/i+n%i;
                break;
            }
        }
        return answer;
    }
}
