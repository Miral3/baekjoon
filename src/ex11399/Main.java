package ex11399;

/*
문제 이름: ATM
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int[] dp = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(p);

        dp[0] = p[0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + p[i];
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += dp[i];
        }

        System.out.println(answer);

        br.close();
        bw.close();
    }
}
