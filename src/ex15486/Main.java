package ex15486;

/*
문제 이름: 퇴사 2
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1500010;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] term = new int[MAX];
        int[] pay = new int[MAX];
        int[] dp = new int[MAX];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");

            term[i] = Integer.parseInt(input[0]);
            pay[i] = Integer.parseInt(input[1]);
        }

        int curMax = 0;
        for (int i = 1; i <= n + 1; i++) {
            curMax = Math.max(curMax, dp[i]);

            if(i + term[i] <= n + 1) {
                dp[i + term[i]] = Math.max(curMax + pay[i], dp[i + term[i]]);
            }
        }

        bw.write(dp[n + 1] + "\n");
        br.close();
        bw.close();
    }
}
