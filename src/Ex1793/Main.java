package Ex1793;

/*
문제 이름 : 타일링
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

    BigInteger[] dp = new BigInteger[251];
    dp[0] = new BigInteger("1");
    dp[1] = new BigInteger("1");
    dp[2] = new BigInteger("3");

    for(int i = 3; i <= 250; i++) {
      dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
    }

    String input;
    while((input = br.readLine()) != null) {
      int n = Integer.parseInt(input);
      bw.write(dp[n] + "\n");
    }

    br.close();
    bw.close();
  }
}