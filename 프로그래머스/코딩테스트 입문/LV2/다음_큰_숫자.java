package LV2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        int countOne = countOne(binary);
        while (true) {
            n++;
            String nextBinary = Integer.toBinaryString(n);
            int nextCountOne = countOne(nextBinary);
            if (countOne == nextCountOne) {
                answer = n;
                break;
            }
        }
        return answer;
    }

    private int countOne(String binary) {
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
