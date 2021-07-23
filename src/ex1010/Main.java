package ex1010;

/*
문제 이름: 다리 놓기
알고리즘: 조합, 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        dp = new int[31][31];
        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            dp[n][r] = comb(n ,r);
            bw.write(dp[n][r] + "\n");
        }

        br.close();
        bw.close();
    }

    public static int comb(int n, int r) {
        if(r == 0 || r == n) {
            return 1;
        } else if(r == 1) {
            return n;
        }
        if(dp[n][r] != 0) {
            return dp[n][r];
        }
        return comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
