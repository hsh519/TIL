package LV2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int cnt = 1;
        while(true) {
            if (yellow % cnt != 0) {
                cnt++;
                continue;
            }
            int w = yellow / cnt;
            if ( (w+2) * 2 + cnt * 2 == brown) {
                answer[0] = w+2;
                answer[1] = cnt + 2;
                break;
            }
            cnt++;
        }
        return answer;
    }
}
