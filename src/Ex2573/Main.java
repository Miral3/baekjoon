package Ex2573;

/*
문제 이름 : 빙산
알고리즘 : 구현, BFS
자료구조 : 배열, 큐
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {
  static int N, M;
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);

    map = new int[N][M];
    visited = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      String[] input2 =  br.readLine().split(" ");
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(input2[j]);
      }
    }

    int result = 0;
    int cnt = 0;
    while(cnt < 2) {
      cnt = 0;
      boolean isSplit = false;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if(map[i][j] > 0 && !visited[i][j]) {
            BFS(i, j);
            isSplit = true;
            cnt++;
          }
        }
      }

      if(!isSplit && cnt < 2) {
        System.out.println("0");
        return;
      }
      result++;
      visited = new boolean[N][M];
    }

    System.out.println(result - 1);

    br.close();
    bw.close();
  }

  public static void BFS(int startY, int startX) {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(startY, startX));
    visited[startY][startX] = true;

    while(!que.isEmpty()) {
      Node cur = que.poll();
      int y = cur.y;
      int x = cur.x;
      int cnt = 0;

      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (!visited[ny][nx]) {
          if (map[ny][nx] != 0) {
            visited[ny][nx] = true;
            que.add(new Node(ny, nx));
          } else {
            cnt++;
          }
        }
      }
      map[y][x] -= cnt;
      if (map[y][x] < 0) {
        map[y][x] = 0;
      }
    }
  }
}