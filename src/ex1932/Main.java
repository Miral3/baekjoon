package ex1932;

/*
문제 이름: 정수 삼각형
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
                if(i == n-1) {
                    dp[i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        for(int i = n -2 ; i >= 0; i--) {
            for(int j = 0; j < n - 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);

        br.close();
        bw.close();
    }
}
