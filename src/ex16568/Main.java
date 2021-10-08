package ex16568;

/*
문제 이름: 엔비스카의 영혼
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
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        int[] dp = new int[1000001];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i - (a + 1) >= 0) {
                dp[i] = Math.min(dp[i], dp[i - (a + 1)] + 1);
            }
            if(i - (b + 1) >= 0) {
                dp[i] = Math.min(dp[i], dp[i - (b + 1)] + 1);
            }
        }

        bw.write(dp[n] + "\n");

        br.close();
        bw.close();
    }
}
