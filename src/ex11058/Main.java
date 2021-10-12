package ex11058;

/*
문제 이름: 크리보드
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        for(int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        for(int i = 7; i <= n; i++) {
            for(int j = 3; i - j > 0; j++) {
                dp[i] = Math.max((j-1) * dp[i - j], dp[i]);
            }
        }

        bw.write(dp[n] + "\n");
        br.close();
        bw.close();
    }
}
