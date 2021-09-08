package ex2294;

/*
문제 이름: 동전 2
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coin = new int[101];

        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());

            for(int j = coin[i]; j <=k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if(dp[k] == 10001) {
            bw.write(-1 + "\n");
        } else {
            bw.write(dp[k] + "\n");
        }

        br.close();
        bw.close();
    }
}
