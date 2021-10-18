package ex10571;

/*
문제 이름: 다이아몬드
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            float[][] arr = new float[n + 1][2];
            int[] dp = new int[n + 1];

            for(int i = 1; i <= n ; i++) {
                String[] input = br.readLine().split(" ");
                arr[i][0] = Float.parseFloat(input[0]);
                arr[i][1] = Float.parseFloat(input[1]);
            }

            int max = 1;
            for(int i = 1; i <= n; i++) {
                dp[i] = 1;
                for(int j = 1; j < i; j++) {
                    if(arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(dp[i], max);
                    }
                }
            }

            bw.write(max + "\n");
        }
        br.close();
        bw.close();
    }
}
