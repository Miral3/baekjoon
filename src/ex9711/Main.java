package ex9711;

/*
문제 이름: 피보나치
알고리즘: dp
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[10001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i <= t; i++) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);

            for (int j = 2; j <= p; j++) {
                dp[j] = (dp[j - 1] + dp[j - 2]) % q;
            }
            sb.append("Case #" + i + ": " + (dp[p] % q) + "\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
