package ex2670;

/*
문제 이름: 연속부분최대곱
알고리즘: 다이나믹 프로그래밍
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double[] dp = new double[n];
        double max = arr[0];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            double caseOne = arr[i] * dp[i-1];
            double caseTwo = arr[i] * arr[i-1];
            dp[i] = Math.max(caseOne, caseTwo);
            max = Math.max(Math.max(dp[i], arr[i]), max);
        }

        bw.write(String.format("%.3f", max) + "\n");
        br.close();
        bw.close();
    }
}
