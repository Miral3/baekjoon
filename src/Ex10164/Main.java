package Ex10164;

/*
문제 이름 : 격자상의 경로
알고리즘 : 동적계획법
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

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int K = Integer.parseInt(input[2]);
    int[][] map = new int[N+1][M+1];
    long[][]dp = new long[N+1][M+1];

    int idx = 1;
    int x = 0, y = 0;

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        map[i][j] = idx;
        if(idx == K) {
          x = i;
          y = j;
        }
        idx++;
      }
    }

    dp[1][1] = 1;
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        if(i == 1 && j == 1) {
          continue;
        }
        if((i > x && j < y) || (i < x && j > y)) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j-1];
        }
      }
    }
    bw.write(dp[N][M] + "\n");
    br.close();
    bw.close();
  }

}
