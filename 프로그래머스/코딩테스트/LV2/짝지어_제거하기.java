package LV2;

import java.util.*;

public class 짝지어_제거하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stk = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stk.empty()) {
                stk.push(c);
            } else {
                if (stk.peek() != c) {
                    stk.push(c);
                } else {
                    stk.pop();
                }
            }
        }
        return stk.empty() ? 1 : 0;
    }
}
