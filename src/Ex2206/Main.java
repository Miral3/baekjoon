package Ex2206;

/*
문제 이름 : 비슷한 단어
알고리즘 : 구현
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int x, y, cost, breakCnt;

  public Node(int x, int y, int cost, int breakCnt) {
    this.x = x;
    this.y = y;
    this.cost = cost;
    this.breakCnt = breakCnt;
  }
}

public class Main {
  static int N, M, result;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] map;
  static int[][] isVisited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    map = new int[N+1][M+1];
    isVisited = new int[N+1][M+1];

    for(int i = 1; i <= N; i++) {
      input = br.readLine().split("");
      for(int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(input[j-1]);
        isVisited[i][j] = Integer.MAX_VALUE;
      }
    }

    result = Integer.MAX_VALUE;
    BFS(1, 1);

    if(result == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
    br.close();
    bw.close();
  }

  public static void BFS(int y, int x) {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(x, y, 1, 0));
    isVisited[y][x] = 0;

    while(!que.isEmpty()) {
      Node cur = que.poll();

      if(cur.y == N && cur.x == M) {
        result = cur.cost;
        break;
      }

      for(int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if(ny >= 1 && ny <= N && nx >= 1 && nx <= M) {
          if(isVisited[ny][nx] <= cur.breakCnt) {
            continue;
          }
          if(map[ny][nx] == 0) {
            que.add(new Node(nx, ny, cur.cost+1, cur.breakCnt));
            isVisited[ny][nx] = cur.breakCnt;
          } else {
            if(cur.breakCnt == 0) {
              que.add(new Node(nx, ny, cur.cost + 1, cur.breakCnt + 1));
              isVisited[ny][nx] = cur.breakCnt + 1;
            }
          }
        }
      }
    }
  }
}