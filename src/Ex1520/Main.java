package Ex1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int n;
  static int m;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] map;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    m = Integer.parseInt(input[0]);
    n = Integer.parseInt(input[1]);
    map = new int[m+1][n+1];
    dp = new int[m+1][n+1];

    for(int i = 0; i <= m; i++) {
      for(int j = 0; j <= n; j++) {
        dp[i][j] = -1;
      }
    }

    for(int i = 1; i <= m; i++) {
      input = br.readLine().split(" ");
      for(int j = 1; j <= n; j++) {
        map[i][j] = Integer.parseInt(input[j-1]);
      }
    }

    bw.write(DFS(1, 1) + "\n");

    br.close();
    bw.close();
  }
  public static int DFS(int x, int y) {
    if(y == m && x == n) {
      return 1;
    }
    else if(dp[y][x] == -1) {
      dp[y][x] = 0;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
          if (map[ny][nx] < map[y][x]) {
            dp[y][x] += DFS(nx, ny);
          }
        }
      }
    }
    return dp[y][x];
  }
}
