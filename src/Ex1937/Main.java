package Ex1937;

/*
문제 이름 : 욕심쟁이 판다
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
  static int[][] dp;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0 ,0 , 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    dp = new int[N][N];

    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }
    int result = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        result = Math.max(DFS(i, j), result );
      }
    }
    System.out.println(result);
    br.close();
    bw.close();
  }

  public static int DFS(int y, int x) {
    if(dp[y][x] == 0) {
      dp[y][x] = 1;
      int temp = 0;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
          if (map[y][x] < map[ny][nx]) {
            temp = Math.max(temp, DFS(ny, nx));
          }
        }
      }
      dp[y][x] += temp;
    }
    return dp[y][x];
  }
}

