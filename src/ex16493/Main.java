package ex16493;

/*
문제 이름: 최대 페이지 수
알고리즘: dp
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] cost = new int[m + 1];
        int[] page = new int[m + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            input = br.readLine().split(" ");
            cost[i] = Integer.parseInt(input[0]);
            page[i] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (cost[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j-cost[i]] + page[i]);
                }
            }
        }

        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
