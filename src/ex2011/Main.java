package ex2011;

/*
문제 이름: 암호코드
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    final static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        int len = num.length();
        int[] arr = new int[len + 1];
        int[] dp = new int[len + 1];

        for(int i = 0; i < len; i++) {
            arr[i + 1] = num.charAt(i) - '0';
        }

        dp[0] = 1;
        for(int i = 1; i < len + 1; i++) {
            if(arr[i] != 0) {
                dp[i] = (dp[i - 1] + dp[i]) % MOD;
            }

            int x = arr[i - 1] * 10 + arr[i];

            if(10 <= x && x <= 26) {
                dp[i] = (dp[i - 2] + dp[i]) % MOD;
            }
        }

        System.out.println(dp[len]);

        br.close();
        bw.close();
    }
}
