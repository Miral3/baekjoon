package ex16194;

/*
문제 이름: 카드 구매하기 2
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
            dp[i] = arr[i];
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + dp[i]);
            }
        }

        System.out.println(dp[n]);

        br.close();
        bw.close();
    }
}
