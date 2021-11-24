package ex2225;

/*
문제 이름: 합분해
알고리즘: 수학, 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[k + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= k; i++) {
            for(int j = 0; j <= n; j++) {
                for(int l = 0; l <= j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % 1000000000;
                }
            }
        }

        bw.write(dp[k][n] + "\n");
        br.close();
        bw.close();
    }
}
