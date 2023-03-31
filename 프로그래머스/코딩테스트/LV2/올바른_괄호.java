package LV2;

import java.util.*;

public class 올바른_괄호 {
    boolean solution(String s) {
        if (s.length() % 2 == 1 || s.startsWith(")")) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (st.empty() || st.peek() == ')') {
                    return false;
                }
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.empty();
    }
}
