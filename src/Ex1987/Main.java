package Ex1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int R;
  static int C;
  static int max;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {-1, 1, 0, 0};
  static String[][] map;
  static boolean[][] visited;
  static boolean[] color = new boolean[26];
  static Queue<Integer> q = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    R = Integer.parseInt(input[0]);
    C = Integer.parseInt(input[1]);
    map = new String[R][C];
    visited = new boolean[R][C];

    for(int i = 0; i < R; i++) {
      input = br.readLine().split("");
      for(int j = 0; j < C; j++) {
        map[i][j] = input[j];
      }
    }

    visited[0][0] = true;
    color[(int)map[0][0].charAt(0)- 65] = true;
    DFS(0, 0, 1);

    System.out.println(max);
  }

  public static void DFS(int x, int y, int cnt) {
    max = Math.max(cnt, max);

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >= 0 && ny >= 0 && nx < R && ny <C) {
        if(!visited[nx][ny] && !color[(int)map[nx][ny].charAt(0)- 65]) {
          visited[nx][ny] = true;
          color[(int)map[nx][ny].charAt(0)- 65] = true;
          DFS(nx, ny, cnt + 1);
          visited[nx][ny] = false;
          color[(int)map[nx][ny].charAt(0)- 65] = false;
        }
      }
    }
  }
}
