package LV2;

import java.util.*;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> arr = new ArrayList<>();
        int turn = 1;
        int count = 1;

        for (int i=0; i<words.length; i++) {
            if (words[i].length() == 1) {
                answer[0] = turn;
                answer[1] = count;
                break;
            }
            if (arr.isEmpty()) {
                arr.add(words[i]);
                turn++;
            } else if (!arr.contains(words[i])) {
                if (words[i].charAt(0) == words[i-1].charAt(words[i-1].length()-1)) {
                    arr.add(words[i]);
                    turn++;
                } else {
                    answer[0] = turn;
                    answer[1] = count;
                    break;
                }
            } else {
                answer[0] = turn;
                answer[1] = count;
                break;
            }

            if (turn == n+1) {
                turn = 1;
                count++;
            }
        }
        return answer;
    }
}
