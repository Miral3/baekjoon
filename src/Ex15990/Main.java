package Ex15990;

/*
문제 이름 : 1, 2, 3 더하기 5
알고리즘 : 다이나믹 프로그래밍
자료구조 : 베얄
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static final long MOD = 1000000009;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    long[][] dp = new long[100001][4];

    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;

    for(int i = 0; i <testCase; i++) {
      int n = Integer.parseInt(br.readLine());
      for(int j = 4; j <= n; j++) {
        dp[j][1] = ( dp[j-1][2] + dp[j-1][3] ) % MOD;
        dp[j][2] = ( dp[j-2][1] + dp[j-2][3] ) % MOD;
        dp[j][3] = ( dp[j-3][1] + dp[j-3][2] ) % MOD;
      }

      long sum = ( dp[n][1] + dp[n][2] + dp[n][3] ) % MOD;

      bw.write(sum + "\n");
    }

    br.close();
    bw.close();
  }
}