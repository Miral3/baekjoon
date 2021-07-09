package Ex10211;

/*
문제 이름 : Maximum Subarray
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

    int testCase = Integer.parseInt(br.readLine());
    for(int i = 0; i < testCase; i++) {
      int N = Integer.parseInt(br.readLine());
      long[] dp = new long[1001];
      String[] input = br.readLine().split(" ");

      dp[0] = Integer.parseInt(input[0]);

      if(N == 1) {
        bw.write(dp[0] + "\n");
        continue;
      }
      long max = Integer.parseInt(input[0]);
      for(int j = 1; j < N; j++) {
        dp[j] = Math.max(0, dp[j-1]) + Integer.parseInt(input[j]);
        if(max < dp[j]) {
          max = dp[j];
        }
      }

      bw.write(max + "\n");
    }

    br.close();
    bw.close();
  }
}