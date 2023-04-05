package LV2;

public class _124_나라의_숫자 {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            answer = arr[n%3] + answer;
            n = (int)Math.floor((n-1)/3);
        }
        return answer;
    }
}
