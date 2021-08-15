package ex11659;

/*
문제 이름: 구간 합 구하기 4
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        int[] arr = new int[n + 1];
        long[] dp = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        dp[1] = arr[1];
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if(start == end) {
                bw.write(arr[start] + "\n");
                continue;
            }

            bw.write(dp[end] - dp[start - 1] + "\n");
        }

        br.close();
        bw.close();
    }
}
