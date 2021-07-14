package Ex2210;

/*
문제 이름 : 숫자판 점프
알고리즘 : 그래프 탐색
자료구조 : 배열, 해시 셋
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static int[][] map;
  static boolean[][] visited;
  static HashSet<String> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    map = new int[5][5];
    visited = new boolean[5][5];
    for(int i = 0; i < 5; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < 5; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        DFS(i, j, Integer.toString(map[i][j]), 1);
      }
    }

    System.out.println(set.size());

    br.close();
    bw.close();
  }

  public static void DFS(int y, int x, String num, int size) {
    visited = new boolean[5][5];

    if(size == 6) {
      if (set.contains(num)) {
        return;
      }
      set.add(num);
      return;
    }
    for(int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny >= 0 && nx >= 0 && ny < 5 && nx < 5) {
        if(!visited[ny][nx]) {
          visited[ny][nx] = true;
          DFS(ny, nx, num + Integer.toString(map[ny][nx]), size + 1);
          visited[ny][nx] = false;
        }
      }
    }
  }
}