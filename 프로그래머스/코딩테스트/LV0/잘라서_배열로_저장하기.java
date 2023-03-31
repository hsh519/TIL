package LV0;

import java.util.ArrayList;

public class 잘라서_배열로_저장하기 {
    class Solution {
        public ArrayList<String> solution(String my_str, int n) {
            ArrayList<String> answer = new ArrayList<>();
            while (true) {
                String s = my_str.substring(0, n);
                my_str = my_str.substring(n);
                answer.add(s);
                if (my_str.equals("")) {
                    break;
                }
                if (my_str.length() <= n) {
                    answer.add(my_str);
                    break;
                }
            }
            return answer;
        }
    }
}
