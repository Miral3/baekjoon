package ex18353;

/*
문제 이름: 병사 배치하기
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(n - max + "\n");

        br.close();
        bw.close();
    }
}
