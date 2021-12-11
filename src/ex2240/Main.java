package ex2240;

/*
문제 이름: 자두나무
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int TMAX = 1001;
    static final int WMAX = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[][][] dp = new int[3][TMAX][WMAX];
        int[] arr = new int[TMAX];
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i-1][j] + 1, dp[2][i-1][j-1] + 1);
                    dp[2][i][j] = Math.max(dp[1][i-1][j-1], dp[2][i-1][j]);
                } else {
                    if(i == 1 && j == 1) {
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
                    dp[2][i][j] = Math.max(dp[1][i-1][j-1] + 1, dp[2][i-1][j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= w + 1; i++) {
            result = Math.max(result, Math.max(dp[1][t][i], dp[2][t][i]));
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
