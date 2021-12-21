package ex14728;

/*
문제 이름: 벼락치기
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);
        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            for (int j = 0; j <= t; j++) {
                if(k > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k] + s);
                }
            }
        }

        bw.write(dp[n][t] + "\n");
        br.close();
        bw.close();
    }
}
