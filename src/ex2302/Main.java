package ex2302;

/*
문제 이름: 극장 좌석
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for(int j = 0; j < m; j++) {
            arr[Integer.parseInt(br.readLine())] = -1;
        }

        int cnt = 0;
        int result = 1;
        for(int i = 1; i <= n; i++) {
            if(arr[i] != -1) {
                cnt++;
            } else {
                result *= dp[cnt];
                cnt = 0;
            }
        }
        result *= dp[cnt];

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}
