package Ex9465;

/*
문제 이름 : 스티커
알고리즘 : 다니아믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static final int MAX = 100001;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    for(int i = 0; i < testCase; i++) {
      int N = Integer.parseInt(br.readLine());
      int[][] sticker = new int[3][MAX];
      int[][] dp = new int[3][MAX];

      for(int j = 1; j <= 2; j++) {
        String[] input = br.readLine().split(" ");
        for(int k = 1; k <= N; k++) {
          sticker[j][k] = Integer.parseInt(input[k-1]);
        }
      }

      dp[1][1] = sticker[1][1];
      dp[2][1] = sticker[2][1];
      dp[1][2] = dp[2][1] + sticker[1][2];
      dp[2][2] = dp[1][1] + sticker[2][2];

      for(int j = 3; j <= N; j++) {
        dp[1][j] = Math.max(Math.max(dp[1][j-2], dp[2][j-2]),
            dp[2][j-1]) + sticker[1][j];
        dp[2][j] = Math.max(Math.max(dp[1][j-2], dp[2][j-2]),
            dp[1][j-1]) + sticker[2][j];
      }

      bw.write(Math.max(dp[1][N], dp[2][N]) + "\n");
    }

    br.close();
    bw.close();
  }
}
