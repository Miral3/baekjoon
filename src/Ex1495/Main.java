package Ex1495;

/*
문제 이름 : 기타리스트
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

    String[] input1 = br.readLine().split(" ");
    int N = Integer.parseInt(input1[0]);
    int S = Integer.parseInt(input1[1]);
    int M = Integer.parseInt(input1[2]);

    int[] v = new int[N+1];
    boolean[][] dp = new boolean[N+1][M+1];
    String[] input2 = br.readLine().split(" ");
    for(int i = 1; i <= N; i++) {
      v[i] = Integer.parseInt(input2[i-1]);
    }

    dp[0][S] = true;
    for(int i = 1; i <= N; i++) {
      for(int j = 0; j <= M; j++) {
        if(!dp[i-1][j]) {
          continue;
        }
        if(j - v[i] >= 0) {
          dp[i][j - v[i]] = true;
        }
        if(j + v[i] <= M) {
          dp[i][j + v[i]] = true;
        }
      }
    }

    for(int i = M; i >= 0; i--) {
      if(dp[N][i]) {
        System.out.println(i);
        return;
      }
    }

    System.out.println(-1);

    br.close();
    bw.close();
  }
}