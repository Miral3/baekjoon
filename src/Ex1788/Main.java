package Ex1788;

/*
문제 이름 : 피보나치 수의 확장
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static final int MOD = 1000000000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[1000001];
    int abs = Math.abs(n);

    if(n >= 0) {
      dp[0] = 0;
      dp[1] = 1;
      for(int i = 2; i <= n; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % MOD;
      }
    } else if(n <= 0){
      dp[0] = 0;
      dp[1] = 1;
      for(int i = 2; i <= abs; i++) {
        dp[i] = (dp[i-2] - dp[i-1]) % MOD;
      }
    }

    if(dp[abs] == 0) {
      System.out.println(0);
    } else if(dp[abs] > 0) {
      System.out.println(1);
    } else {
      System.out.println(-1);
    }
    System.out.println(Math.abs(dp[abs]));
    br.close();
    bw.close();
  }
}