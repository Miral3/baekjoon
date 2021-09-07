package ex2293;

/*
문제 이름: 동전 1
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
        int k = Integer.parseInt(input[1]);
        int[] coin = new int[101];

        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[10001];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        bw.write(dp[k] + "\n");

        br.close();
        bw.close();
    }
}
