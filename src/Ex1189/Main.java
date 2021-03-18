package Ex1189;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int R, C, K; //세로, 가로, 갈 수 있는 거리
  static int result = 0;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static String[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    R = Integer.parseInt(input[0]);
    C = Integer.parseInt(input[1]);
    K = Integer.parseInt(input[2]);

    map = new String[R][C];
    visited = new boolean[R][C];
    visited[R-1][0] = true;

    for(int i = 0; i < R; i++) {
      input = br.readLine().split("");
      for(int j = 0; j < C; j++) {
        map[i][j] = input[j];
      }
    }

    DFS(R-1, 0, 1);
    bw.write(result+ "\n");

    br.close();
    bw.close();
  }

  public static void DFS(int x, int y, int cnt) {
    if((x == 0) && (y == C-1) && (cnt == K)) {
      result++;
      return;
    }

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
        if(!visited[nx][ny] && !map[nx][ny].equals("T")) {
          visited[nx][ny] = true;
          DFS(nx, ny, cnt + 1);
          visited[nx][ny] = false;
        }
      }
    }
  }

}
