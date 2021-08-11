package ex17626;

/*
문제 이름: Four Squares
알고리즘: 다이나믹 프로그래밍, 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            Double sqrt = Math.sqrt(i);

            if(sqrt == sqrt.intValue()) {
                dp[i] = 1;
                continue;
            }

            int num = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= num; j++) {
                int pow = (int)Math.pow(j , 2);
                min = Math.min(dp[pow] + dp[i - pow], min);
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);

        br.close();
        bw.close();
    }
}
