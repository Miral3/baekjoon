package ex1563;

/*
문제 이름: 개근상
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][][] dp = new int[1001][3][4];
    static int n;
    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        bw.write(func(0, 0, 0) + "\n");
        br.close();
        bw.close();
    }

    public static int func(int day, int l, int a) {
        if(dp[day][l][a] != -1) {
            return dp[day][l][a];
        }

        if (l >= 2 || a >= 3) {
            return 0;
        }

        if(day == n) {
            return 1;
        }

        dp[day][l][a] = 0;
        dp[day][l][a] = func(day + 1, l, 0) + func(day + 1, l + 1, 0) + func(day + 1, l, a + 1);

        return  dp[day][l][a] % MOD;
    }
}
