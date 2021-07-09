package Ex2615;

/*
문제 이름 : 오목
알고리즘 : 구현, 브루트포스
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = 19;
    map = new int[n][n];

    for(int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }
    // 가로
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < 15; j++) {
        if(map[i][j] == 0) {
          continue;
        }

        int k = 1;
        for(k = 1; k < 5; k++) {
          if(map[i][j] != map[i][j+k]) {
            break;
          }
        }

        if(k < 5) {
          continue;
        }
        if((j == 14 || map[i][j+5] != map[i][j]) &&
            (j == 0 || map[i][j-1] != map[i][j])) {
          print(i, j);
        }
      }
    }
    // 세로
    for(int j = 0; j < n; j++) {
      for(int i = 0; i < 15; i++) {
        if(map[i][j] == 0) {
          continue;
        }

        int k = 1;
        for(k = 1; k < 5; k++) {
          if(map[i][j] != map[i+k][j]) {
            break;
          }
        }

        if(k < 5) {
          continue;
        }
        if((i == 14 || map[i+5][j] != map[i][j]) &&
            (i == 0 || map[i-1][j] != map[i][j])) {
          print(i, j);
        }
      }
    }
    // 오른쪽 아래 대각선
    for(int i = 0; i < 15; i++) {
      for(int j = 0; j < 15; j++) {
        if(map[i][j] == 0) {
          continue;
        }

        int k = 1;
        for(k = 1; k < 5; k++) {
          if(map[i][j] != map[i+k][j+k]) {
            break;
          }
        }

        if(k < 5) {
          continue;
        }
        if((i == 14 || j == 14 || map[i+5][j+5] != map[i][j]) &&
            (i == 0 || j == 0 || map[i-1][j-1] != map[i][j])) {
          print(i, j);
        }
      }
    }
    // 오른쪽 위 대각선
    for(int j = 0; j < 15; j++) {
      for(int i = 4; i < n; i++) {
        if(map[i][j] == 0) {
          continue;
        }

        int k = 1;
        for(k = 1; k < 5; k++) {
          if(map[i][j] != map[i-k][j+k]) {
            break;
          }
        }

        if(k < 5) {
          continue;
        }
        if((i == 4 || j == 14 || map[i-5][j + 5] != map[i][j]) &&
            (j == 14 || j == 0 || map[i+1][j-1] != map[i][j])) {
          print(i, j);
        }
      }
    }

    br.close();
    bw.close();
  }
  public static void print(int x, int y) {
    System.out.println(map[x][y]);
    System.out.print((x + 1) + " " + (y + 1));
    System.exit(0);
  }
}