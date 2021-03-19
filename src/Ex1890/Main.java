package Ex1890;

/*
문제 이름 : 점프
알고리즘 : 다이나믹 프로그래밍
자료구조 : 배열
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int N;
  static int[][] map;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    dp = new long[N][N];
    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        dp[i][j] = -1;
      }
    }

    bw.write(DFS(0, 0) + "\n");
    br.close();
    bw.close();
  }

  public static long DFS(int x, int y) {
    int num = map[x][y];

    if(x == N-1 && y == N-1) {
      return 1;
    }
    else if(dp[x][y] == -1) {
      dp[x][y] = 0;

      int rightx = x;
      int righty = y + num;
      if (rightx >= 0 && righty >= 0 && rightx < N && righty < N) {
        dp[x][y] += DFS(rightx, righty);
      }

      int downx = x + num;
      int downy = y;
      if (downx >= 0 && downy >= 0 && downx < N && downy < N) {
        dp[x][y] += DFS(downx, downy);
      }
    }
    return dp[x][y];
  }
}
