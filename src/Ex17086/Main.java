package Ex17086;

/*
문제 이름 : 아기 상어2
알고리즘 : 그래프 탐색
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int y, x, cnt;

  public Node(int y, int x, int cnt) {
    this.y = y;
    this.x = x;
    this.cnt = cnt;
  }
}
public class Main {
  static int N, M;
  static int result;
  static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
  static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);

    map = new int[N][M];
    for(int i = 0; i < N; i++) {
      String[] input2 = br.readLine().split(" ");
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(input2[j]);
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j] == 0) {
          visited = new boolean[N][M];
          result = Math.max(result, BFS(i, j));
        }
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }

  public static int BFS(int y, int x) {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(y, x, 0));
    visited[y][x] = true;

    while(!que.isEmpty()) {
      Node cur = que.poll();
      int cy = cur.y;
      int cx = cur.x;
      int cnt = cur.cnt;

      if(map[cy][cx] == 1) {
        return cnt;
      }
      for (int i = 0; i < 8; i++) {
        int ny = cy + dy[i];
        int nx = cx + dx[i];

        if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
          if (!visited[ny][nx]) {
            que.add(new Node(ny,nx, cnt + 1));
            visited[ny][nx] = true;
          }
        }
      }
    }
    return 0;
  }
}