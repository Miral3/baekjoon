package Ex2407;

/*
문제 이름 : 조합
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

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    BigInteger[][] dp = new BigInteger[101][101];

    dp[1][0] = BigInteger.ONE;
    dp[1][1] = BigInteger.ONE;

    for(int i = 2; i < 101; i++) {
      for(int j = 0; j <= i; j++) {
        if(i == j || j == 0) {
          dp[i][j] = BigInteger.ONE;
        } else {
          dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
        }
      }
    }

    System.out.println(String.format(dp[n][m].toString()));

    br.close();
    bw.close();
  }
}