/*
문제 이름 : 1, 2, 3 더하기
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
 */
package Ex9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase= Integer.parseInt(br.readLine());
    int[] dp = new int[12];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for(int i = 4; i < 12; i++) {
      dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
    }

    for(int i = 0; i < testCase; i++) {
      int N = Integer.parseInt(br.readLine());
      bw.write(dp[N] + "\n");
    }

    br.close();
    bw.close();
  }
}
