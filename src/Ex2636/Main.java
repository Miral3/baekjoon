package Ex2636;

/*
문제 이름 : 치즈
알고리즘 : 구현
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
  int y;
  int x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {
  static int column;
  static int row;
  static int answer;
  static int count;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[][] map;
  static boolean[][] visited;
  static boolean[][] outsideAir;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    answer = 0;
    count = 0;
    String[] input1 = br.readLine().split(" ");
    column = Integer.parseInt(input1[0]);
    row = Integer.parseInt(input1[1]);

    map = new int[column][row];
    visited = new boolean[column][row];
    outsideAir = new boolean[column][row];

    for(int i = 0; i < column; i++) {
      String[] input2 = br.readLine().split(" ");
      for(int j = 0; j < row; j++) {
        map[i][j] = Integer.parseInt(input2[j]);
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
    System.out.println(time + "\n" + answer);

    br.close();
    bw.close();
  }

  public static void BFS() {
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(0, 0));
    visited[0][0] = true;
    outsideAir[0][0] = true;

    while(!que.isEmpty()) {
      Node curNode = que.poll();
      int y = curNode.y;
      int x = curNode.x;

      for(int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if(ny >= 0 && nx >= 0 && ny < column && nx < row) {
          if(!visited[ny][nx] && map[ny][nx] == 0) {
            visited[ny][nx] = true;
            outsideAir[ny][nx] = true;
            que.add(new Node(ny, nx));
          }
        }
      }
    }

    LinkedList<Node> list = new LinkedList<>();
    int removing = 0;
    for(int i = 0; i < column; i++) {
      for(int j = 0; j < row; j++) {
        visited[i][j] = false;
        if(map[i][j] == 1) {
          for(int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if(ny >= 0 && nx >= 0 && ny < column && nx < row) {
              if(outsideAir[ny][nx]) {
                list.add(new Node(i, j));
                break;
              }
            }
          }
        }
      }
    }
    removing = list.size();
    for(int i = 0; i < removing; i++) {
      Node cur = list.poll();
      int y = cur.y;
      int x= cur.x;
      outsideAir[y][x] = false;
      map[y][x] = 0;
    }

    if(count - removing == 0) {
      answer = removing;
    }
    count -= removing;
  }
}