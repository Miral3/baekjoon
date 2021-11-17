package ex17404;

/*
문제 이름: RGB거리 2
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = MAX;
        for(int k = 0; k < 3; k++) {

            for(int i = 0; i < 3; i++) {
                if(k == i) {
                    dp[0][i] = cost[0][i];
                } else {
                    dp[0][i] = MAX;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for(int i = 0; i < 3; i++) {
                if(k == i) {
                    continue;
                }
                result = Math.min(result, dp[n-1][i]);
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
