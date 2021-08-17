package ex1660;

/*
문제 이름: 캡틴 이다솜
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[300001];
        int[] arr2 = new int[300001];

        arr[1] = 1;
        arr2[1] = 1;
        int idx = 2;
        while(true) {
            arr[idx] = arr[idx - 1] + idx;
            arr2[idx] = arr2[idx - 1] + arr[idx];

            if(arr2[idx] > n) {
                break;
            }

            idx++;
        }


        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = idx - 1; j >= 1; j--) {
                if(i >= arr2[j]) {
                    int value = dp[arr2[j]] + dp[i - arr2[j]];
                    min = Math.min(value, min);
                }
            }
            dp[i] = min;
        }

        bw.write(dp[n] + "\n");

        br.close();
        bw.close();
    }
}
