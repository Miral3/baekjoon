package ex17271;

/*
문제 이름: 리그 오브 레전설 (Small)
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
        int m = Integer.parseInt(input[1]);
        int[] dp = new int[n + m + 1];
        dp[1] = 1;
        dp[m] = 1;

        int remain = 1000000007;
        for (int i = 2; i <= n; i++) {
            dp[i] += dp[i - 1] % remain;
            if (i - m > 0) {
                dp[i] += dp[i - m] % remain;
            }
        }


        bw.write((dp[n] % remain) + "\n");
        br.close();
        bw.close();
    }
}
