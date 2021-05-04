package Ex13699;

/*
문제 이름 : 점화식
알고리즘 : 다니아믹 프로그래밍
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
    long[] dp = new long[n+1];

    dp[0] = 1;
    for(int i = 1; i <= n; i++) {
      for(int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i-j-1];
      }
    }

    bw.write(dp[n] + "\n");
    br.close();
    bw.close();
  }
}
