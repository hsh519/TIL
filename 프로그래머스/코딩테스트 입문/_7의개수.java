public class _7의개수 {
    public int solution(int[] array) {
        int answer = 0;
        for (int n: array) {
            String s = String.valueOf(n);
            answer += s.chars().filter(m -> m == '7').count();
        }
        return answer;
    }
}
