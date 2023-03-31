package LV0;

public class 다음에_올_숫자 {
    public int solution(int[] common) {
        int answer = 0;
        int first = common[1] - common[0];
        int second = common[2] - common[1];
        if (first == second) {
            answer = common[common.length-1] + first;
        } else {
            answer = common[common.length-1] * (common[1] / common[0]);
        }
        return answer;
    }
}

