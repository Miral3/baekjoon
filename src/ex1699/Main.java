package ex1699;

/*
문제 이름: 제곱수의 합
알고리즘: 다이나믹 프로그래밍, 정수론
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; i++) {
            if(isSqrt((long)i)) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                int sqrt = (int)Math.sqrt(i);
                for(int j = 0; j < sqrt; j++) {
                    int pow = (int)Math.pow(sqrt - j, 2);
                    min = Math.min(dp[pow] + dp[i - pow], min);
                }

                dp[i] = min;
            }
        }

        bw.write(dp[n] + "\n");

        br.close();
        bw.close();
    }

    public static boolean isSqrt(long n) {
        Double sqrt = Math.sqrt(n);

        if(sqrt == sqrt.intValue()) {
            return true;
        }
        return false;
    }
}
