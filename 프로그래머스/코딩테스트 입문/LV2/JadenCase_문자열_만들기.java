package LV2;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";
        char[] c = s.toCharArray();

        for (int i=0; i<c.length; i++) {
            if(i == 0 || c[i-1] == ' ') {
                if('a' <= c[i] && c[i] <= 'z') {
                    answer += (Character.toString(c[i])).toUpperCase();
                } else {
                    answer += c[i];
                }
            } else {
                if('A' <= c[i] && c[i] <= 'Z') {
                    answer += (Character.toString(c[i])).toLowerCase();
                } else {
                    answer += c[i];
                }
            }
        }
        return answer;
    }
}
