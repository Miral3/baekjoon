package ex17212;

/*
문제 이름: 달나라 토끼를 위한 구매대금 지불 도우미
알고리즘: 다이나믹 프로그래밍
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
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;
        for(int i = 8; i <= n; i++) {
            int value = 0;
            int min = Integer.MAX_VALUE;
            if(i > 7) {
                value = dp[7] + dp[i - 7];
                min = Math.min(value, min);
            }
            if(i > 5) {
                value = dp[5] + dp[i - 5];
                min = Math.min(value, min);
            }
            if(i > 2) {
                value = dp[2] + dp[i - 2];
                min = Math.min(value, min);
            }
            if(i > 1) {
                value = dp[1] + dp[i - 1];
                min = Math.min(value, min);
            }
            dp[i] = min;
        }

        bw.write(dp[n] + "\n");

        br.close();
        bw.close();
    }
}
