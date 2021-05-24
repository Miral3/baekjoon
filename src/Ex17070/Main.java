package Ex17070;

/*
문제 이름 : 파이프 옮기기 1
알고리즘 : 다이나믹 프로그래밍
자료구조 : 베얄
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int N, cnt;
  static int[] dx = {1, 0, 1};
  static int[] dy = {0, 1, 1};
  static int[][] map;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1];

    for(int i = 1; i <= N; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(input[j-1]);
      }
    }
    cnt = 0;
    DFS(1, 2, 0);
    bw.write(cnt + "\n");

    br.close();
    bw.close();
  }

  public static void DFS(int y, int x, int state) {
    if(x == N && y == N) {
      cnt++;
      return;
    }
    for(int i = 0; i < 3; i++) {
      if ((i == 0 && state == 1) || (i == 1 && state == 0)) {
        continue;
      }

      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny >= N+1 || nx >= N+1 || map[ny][nx] == 1) {
        continue;
      }
      if (i == 2 && (map[y][x + 1] == 1 || map[y + 1][x] == 1)) {
        continue;
      }
      DFS(ny, nx, i);
    }
  }
}