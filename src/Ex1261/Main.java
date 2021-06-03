package Ex1261;

/*
문제 이름 : 알고스팟
알고리즘 : 다익스트라
자료구조 : 배열, 우선순위 큐
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
  int y, x, drill;

  public Node(int y, int x, int drill) {
    this.y = y;
    this.x = x;
    this.drill = drill;
  }

  @Override
  public int compareTo(Node o) {
    return drill - o.drill;
  }
}
public class Main {
  static int N, M;
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {-1, 0, 1, 0};
  static int[][] map;
  static boolean[][] isVisted;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    M = Integer.parseInt(input[0]);
    N = Integer.parseInt(input[1]);


    map = new int[N+1][M+1];
    isVisted = new boolean[N+1][M+1];

    for(int i = 1; i <= N; i++) {
      input = br.readLine().split("");
      for(int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(input[j-1]);
      }
    }

    System.out.println(dijkstra(1, 1));
    br.close();
    bw.close();
  }

  public static int dijkstra(int y, int x) {
    PriorityQueue<Node> que = new PriorityQueue<>();
    que.add(new Node(y, x, 0));
    isVisted[y][x] = true;

    while(!que.isEmpty()) {
      Node cur = que.poll();

      if(cur.y == N && cur.x == M) {
        return cur.drill;
      }

      for(int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if(nx < 1 || ny < 1 || nx > M || ny > N) {
          continue;
        }
        if(isVisted[ny][nx]) {
          continue;
        }

        if(map[ny][nx] == 0) {
          que.add(new Node(ny, nx, cur.drill));
          isVisted[ny][nx] = true;
        }
        else if(map[ny][nx] == 1) {
          que.add(new Node(ny, nx, cur.drill + 1));
          isVisted[ny][nx] = true;
        }
      }
    }
    return 0;
  }
}