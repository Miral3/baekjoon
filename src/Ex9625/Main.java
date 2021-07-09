package Ex9625;

/*
문제 이름 : BABBA
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

    int K = Integer.parseInt(br.readLine());
    int[][] dp = new int[46][2];

    dp[1][0] = 0;
    dp[1][1] = 1;
    for(int i = 2; i <= K; i++) {
      int A = dp[i-1][0];
      int B = dp[i-1][1];

      dp[i][0] = B;
      dp[i][1] = A + B;
    }

    System.out.println(dp[K][0] + " " + dp[K][1]);

    br.close();
    bw.close();
  }
}