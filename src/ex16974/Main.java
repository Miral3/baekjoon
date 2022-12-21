package ex16974;

/*
문제 이름: 레벨 햄버거
알고리즘: 수학, 다이나믹 프로그래밍, 분할 정복, 재귀
자료구조: 배열
*/

import java.io.*;

public class Main {
    static long[][] dp;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long x = Long.parseLong(input[1]);
        dp = new long[n + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 3 + dp[i - 1][0] * 2;
            dp[i][1] = 1 + dp[i - 1][1] * 2;
        }

        dfs(n, x);
        bw.write(answer + "\n");

        br.close();
        bw.close();
    }
    public static void dfs(int n, long x) {
        if (x == 1) {
            if (n == 0) {
                answer += 1;
            }
            return;
        }
        if (x >= 2 && x < dp[n - 1][0] + 1) {
            dfs(n - 1, x - 1);
        }
        if (x == dp[n - 1][0] + 1) {
            answer += dp[n - 1][1];
            return;
        }
        if (x == dp[n - 1][0] + 2) {
            answer += dp[n - 1][1] + 1;
            return;
        }
        if (x >= dp[n -1][0] + 1&& x < dp[n][0]) {
            answer += dp[n - 1][1] + 1;
            dfs(n - 1, x - 2 - dp[n - 1][0]);
        }
        if (x == dp[n][0]) {
            answer += dp[n][1];
            return;
        }
    }
}
