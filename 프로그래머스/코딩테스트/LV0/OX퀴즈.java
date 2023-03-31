package LV0;

public class OX퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int seq = 0;
        for (String s: quiz) {
            String[] arr = s.split(" ");
            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[2]);
            int res = Integer.parseInt(arr[4]);
            if (arr[1].equals("-")) {
                if (num1 - num2 == res) {
                    answer[seq++] = "O";
                } else {
                    answer[seq++] = "X";
                }
            } else {
                if (num1 + num2 == res) {
                    answer[seq++] = "O";
                } else {
                    answer[seq++] = "X";
                }
            }
        }
        return answer;
    }
}
