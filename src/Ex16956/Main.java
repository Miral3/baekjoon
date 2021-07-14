package Ex16956;

/*
문제 이름 : 늑대와 양
알고리즘 : 그래프 탐색
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {
  static int R, C;
  static int dx[] = {0, 0, -1, 1};
  static int dy[] = {-1, 1, 0, 0};
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

    for(int i = 0; i < R; i++) {
      String[] input2 = br.readLine().split("");
      for(int j = 0; j < C; j++) {
        map[i][j] = input2[j];
      }
    }

    for(int i = 0; i < R; i++) {
      for(int j = 0; j < C; j++) {
        if(map[i][j].equals("S")) {
          for(int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];
            if(ny >= 0 && nx >= 0 && ny < R && nx < C) {
              if (map[ny][nx].equals(".")) {
                map[ny][nx] = "D";
              } else if (map[ny][nx].equals("W")) {
                System.out.println(0);
                return;
              }
            }
          }
        }
      }
    }

    System.out.println(1);
    for(int i = 0; i < R; i++) {
      for(int j = 0; j < C; j++) {
        bw.write(map[i][j] + "");
      }
      bw.write("\n");
    }

    br.close();
    bw.close();
  }
}