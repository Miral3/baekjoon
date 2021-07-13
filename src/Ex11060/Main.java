package Ex11060;

/*
문제 이름 : 점프 점프
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[1001];
    int[] dp = new int[1001];

    String[] input = br.readLine().split(" ");
    for(int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(input[i-1]);
    }

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[1] = 0;
    for(int i = 1; i <= N; i++) {
      if(dp[i] != Integer.MAX_VALUE) {

        int num = arr[i];
        for (int j = 1; j <= num; j++) {
          if(i + j > N) {
            continue;
          }
          dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
        }
      }
    }

    if(dp[N] == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(dp[N]);
    }

    br.close();
    bw.close();
  }
}