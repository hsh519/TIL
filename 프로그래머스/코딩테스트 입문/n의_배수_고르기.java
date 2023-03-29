import java.util.Arrays;

public class n의_배수_고르기 {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(m -> (m % n == 0)).toArray();
    }
}
