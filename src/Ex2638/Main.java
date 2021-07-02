package Ex2638;

/*
문제 이름 : 치즈
알고리즘 : 구현, BFS
자료구조 : 큐, 리스트, 배열
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
  static int N, M, count;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] map;
  static boolean[][] outsideAir;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    count = 0;

    map = new int[N][M];
    outsideAir = new boolean[N][M];
    visited = new boolean[N][M];

    for(int i = 0; i < N ; i++) {
      input = br.readLine().split(" ");
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(input[j]);
        if(map[i][j] == 1) {
          count++;
        }
      }
    }

    int time = 0;
    while(count > 0) {
      time++;
      BFS();
    }

    System.out.println(time);

    br.close();
    bw.close();
  }

  public static void BFS() {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(0, 0));
    outsideAir[0][0] = true;
    visited[0][0] = true;

    while(!que.isEmpty()) {
      Node cur = que.poll();
      int y = cur.y;
      int x = cur.x;

      for(int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny >= 0 && nx >= 0 && ny < N && nx < M) {
          if(!visited[ny][nx] && map[ny][nx] == 0) {
            outsideAir[ny][nx] = true;
            visited[ny][nx] = true;
            que.add(new Node(ny, nx));
          }
        }
      }
    }

    LinkedList<Node> list = new LinkedList<>();
    int size = 0;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        visited[i][j] = false;
        if(map[i][j] == 1) {
          int contact = 0;
          for(int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if(ny >= 0 && nx >= 0 && ny < N && nx < M) {
              if(outsideAir[ny][nx]) {
                contact++;
              }
            }
            if(contact >= 2) {
              list.add(new Node(i ,j));
              break;
            }
          }
        }
      }
    }
    size = list.size();
    for(int i = 0; i < size; i++) {
      Node cur = list.poll();
      int y = cur.y;
      int x = cur.x;
      outsideAir[y][x] = false;
      map[y][x] = 0;
    }
    count -= size;
  }
}
