package ex2705;

/*
문제 이름: 팰린드롬 파티션
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static final int MAX = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];
        Arrays.fill(dp, 1);

        dp[0] = 0;
        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i - j) % 2 == 0) {
                    dp[i] += dp[(i - j) / 2];
                }
            }
        }

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
