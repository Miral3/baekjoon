package ex4097;

/*
문제 이름: 수익
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            dp[1] = arr[1];
            int result = -100001;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
                result = Math.max(dp[i], result);
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
