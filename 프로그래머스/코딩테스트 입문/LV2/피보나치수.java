package LV2;

public class 피보나치수 {
    public int solution(int n) {
        int[] f = new int[n+1];
        int num = 1234567;
        for (int i=0; i<n+1; i++) {
            if (i == 0) {
                f[0] = 0;
            } else if (i == 1) {
                f[1] = 1;
            } else {
                if(f[i-1] + f[i-2] >= 1234567) {
                    f[i] = (f[i-1] + f[i-2]) % 1234567;
                } else {
                    f[i] = f[i-1] + f[i-2];
                }
            }
        }

        return f[n];
    }
}
