public class 숫자찾기 {
    public int solution(int num, int k) {
        String s = Integer.toString(num);
        String search = Integer.toString(k);
        return s.contains(search) ? s.indexOf(search)+1 : -1;
    }
}
