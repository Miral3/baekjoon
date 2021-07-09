package Ex10826;

/*
문제 이름 : 피보나치 수 4
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    BigInteger[] dp = new BigInteger[10001];

    dp[0] = BigInteger.ZERO;
    dp[1] = BigInteger.ONE;

    for(int i = 2; i <= n; i++) {
      dp[i] = dp[i-1].add(dp[i-2]);
    }

    System.out.println(dp[n]);

    br.close();
    bw.close();
  }
}