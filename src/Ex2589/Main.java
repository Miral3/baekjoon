package Ex2589;

/*
문제 이름 : 보물섬
알고리즘 : BFS
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
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int[][] route;
  static String[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);

    map = new String[N][M];


    for(int i = 0; i < N; i++) {
      String[] input2 = br.readLine().split("");
      for(int j = 0; j < M; j++) {
        map[i][j] = input2[j];
      }
    }

    int result = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(map[i][j].equals("L")) {
          route = new int[N][M];
          visited = new boolean[N][M];
          result = Math.max(result, BFS(i, j));
        }
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }

  public static int BFS(int startY, int startX) {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(startY, startX));
    visited[startY][startX] = true;
    int max = 0;

    while(!que.isEmpty()) {
      Node cur = que.poll();
      int y = cur.y;
      int x = cur.x;

      for(int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny >= 0 && nx >= 0 && ny < N && nx < M) {
          if(!visited[ny][nx] && map[ny][nx].equals("L")) {
            que.add(new Node(ny, nx));
            visited[ny][nx] = true;
            route[ny][nx] += route[y][x] + 1;

            if(max < route[ny][nx]) {
              max = route[ny][nx];
            }
          }
        }
      }
    }

    return max;
  }
}