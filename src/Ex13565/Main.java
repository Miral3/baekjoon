package Ex13565;

/*
문제 이름 : 침투
알고리즘 : 그래프 탐색
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int M, N;
  static String result;
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    M = Integer.parseInt(input1[0]);
    N = Integer.parseInt(input1[1]);

    map = new int[M][N];
    visited = new boolean[M][N];

    for(int i = 0; i < M; i++) {
      String[] input2 = br.readLine().split("");
      for(int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input2[j]);
      }
    }

    result = "NO";
    for(int i = 0; i < N; i++) {
      if(!visited[M-1][i] && map[M-1][i] == 0) {
        DFS(M-1, i);
      }
    }

    System.out.println(result);
    br.close();
    bw.close();
  }

  public static void DFS(int y, int x) {
    visited[y][x] = true;

    if(y == 0) {
      result = "YES";
    }
    for(int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny >= 0 && nx >=0 && ny < M && nx < N) {
        if(!visited[ny][nx] && map[ny][nx] == 0) {
          DFS(ny, nx);
        }
      }
    }
  }
}