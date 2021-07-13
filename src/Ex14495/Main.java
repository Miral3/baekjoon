package Ex14495;

/*
문제 이름 : 피보나치 비스무리한 수열
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[117];

    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    for(int i = 4; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-3];
    }

    System.out.println(dp[n]);

    br.close();
    bw.close();
  }
}