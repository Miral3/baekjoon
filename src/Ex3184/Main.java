package Ex3184;

/*
문제 이름 : 양
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
  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {
  static int R, C;
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static int[] result;
  static String[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    R = Integer.parseInt(input1[0]);
    C = Integer.parseInt(input1[1]);

    map = new String[R][C];
    visited = new boolean[R][C];
    result = new int[2];

    for(int i = 0; i < R; i++) {
      String[] input2 = br.readLine().split("");
      for(int j = 0; j < C; j++) {
        map[i][j] = input2[j];
      }
    }

    for(int i = 0; i < R; i++) {
      for(int j = 0; j < C; j++) {
        if(!visited[i][j] && (map[i][j].equals("o") || map[i][j].equals("v"))) {
          BFS(i, j);
        }
      }
    }

    System.out.println(result[0] + " " + result[1]);

    br.close();
    bw.close();
  }

  public static void BFS(int y, int x) {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(y, x));
    visited[y][x] = true;
    int sheep = 0;
    int wolf = 0;

    if(map[y][x].equals("o")) {
      sheep++;
    } else if(map[y][x].equals("v")) {
      wolf++;
    }

    while(!que.isEmpty()) {
      Node cur = que.poll();
      int cy = cur.y;
      int cx = cur.x;

      for(int i = 0; i < 4; i++) {
        int ny = cy + dy[i];
        int nx = cx + dx[i];

        if(ny >= 0 && nx >= 0 && ny < R && nx < C) {
          if(!visited[ny][nx]) {
            if(map[ny][nx].equals("#")) {
              continue;
            }
            else {
              que.add(new Node(ny, nx));
              visited[ny][nx] = true;
              if(map[ny][nx].equals("o")) {
                sheep++;
              } else if(map[ny][nx].equals("v")) {
                wolf++;
              }
            }
          }
        }
      }
    }
    if(sheep > wolf) {
      result[0] += sheep;
    } else {
      result[1] += wolf;
    }
  }
}