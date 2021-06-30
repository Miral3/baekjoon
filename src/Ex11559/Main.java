package Ex11559;

/*
문제 이름 : Puyo Puyo
알고리즘 : 구현, BFS
자료구조 : 큐, 배열
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
  static int column = 12;
  static int row = 6;
  static int result = 0;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static String[][] map;
  static boolean[][] visited;
  static LinkedList<Node> contain;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    map = new String[column][row];
    for(int i = 0; i < column; i++) {
      String[] input = br.readLine().split("");
      for(int j = 0; j < row; j++) {
        map[i][j] = input[j];
      }
    }


    while(true) {
      visited = new boolean[column][row];
      contain = new LinkedList<>();
      for(int i = 0; i < column; i++) {
        for(int j = 0; j < row; j++) {
          if(!map[i][j].equals(".") && !visited[i][j]) {
            BFS(i, j);
          }
        }
      }

      if(contain.isEmpty()) {
        System.out.println(result);
        break;
      } else {
        result++;
      }

      int size = contain.size();
      for(int i = 0; i < size; i++) {
        Node cur = contain.poll();
        int y = cur.y;
        int x = cur.x;
        map[y][x] = ".";
      }

      for(int i = column-2; i >= 0; i--) {
        for(int j = 0; j < row; j++) {
          int cnt = 0;
          if(!map[i][j].equals(".")) {
            for (int k = i + 1; k < column; k++) {
              if (map[k][j].equals(".")) {
                cnt++;
              } else {
                break;
              }
            }
          }
          if(cnt != 0) {
            String temp = map[i][j];
            map[i][j] = map[i+cnt][j];
            map[i+cnt][j] = temp;
          }
        }
      }
    }

    br.close();
    bw.close();
  }
  public static void BFS(int startY, int startX) {
    Queue<Node> que = new LinkedList<>();
    LinkedList<Node> storage = new LinkedList<>();
    String startColor = map[startY][startX];
    int count = 1;

    que.add(new Node(startY, startX));
    storage.add(new Node(startY,startX));
    visited[startY][startX] = true;

    while(!que.isEmpty()) {
      Node nodeCur = que.poll();
      int y = nodeCur.y;
      int x = nodeCur.x;

      for(int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny >= 0 && nx >= 0 && ny < column && nx < row) {
          if(!visited[ny][nx] && map[ny][nx].equals(startColor)) {
            visited[ny][nx] = true;
            que.add(new Node(ny,nx));
            storage.add(new Node(ny,nx));
            count++;
          }
        }
      }
    }

    if(count >= 4) {
      contain.addAll(storage);
    }
  }
}