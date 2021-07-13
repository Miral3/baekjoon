package Ex15988;

/*
문제 이름 : 1, 2, 3 더하기 3
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
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

    int T = Integer.parseInt(br.readLine());
    long[] dp = new long[1000001];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      for(int j = 4; j <= n; j++) {
        if(dp[j] == 0) {
          dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % MOD;
        }
      }
      bw.write(dp[n] + "\n");
    }

    br.close();
    bw.close();
  }
}