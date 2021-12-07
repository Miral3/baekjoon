package ex2410;

/*
문제 이름: 2의 멱수의 합
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1000001;
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];

        dp[0] = 1;
        int shift = 0;

        while ((1 << shift) <= n) {
            for (int i = 0; i <= n; ++i) {
                if (i - (1 << shift) >= 0) {
                    dp[i] = (dp[i] + dp[i - (1 << shift)]) % MOD;
                }
            }
            ++shift;
        }

        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
