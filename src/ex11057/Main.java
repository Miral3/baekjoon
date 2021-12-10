package ex11057;

/*
문제 이름: 오르막 수
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1001;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[MAX][10];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 1 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % MOD;
        }

        bw.write(sum + "\n");
        br.close();
        bw.close();
    }
}
