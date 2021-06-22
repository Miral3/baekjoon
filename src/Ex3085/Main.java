package Ex3085;

/*
문제 이름 : 사탕 게임
알고리즘 : 구현
자료구조 : 2차원 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int N;
  static String[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new String[N][N];

    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split("");
      for(int j = 0; j < N; j++) {
        map[i][j] = input[j];
      }
    }

    int result = 1;
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N - 1; j++) {
          String temp = map[i][j];
          map[i][j] = map[i][j + 1];
          map[i][j + 1] = temp;

          result = Math.max(result, checkCandy());

          temp = map[i][j];
          map[i][j] = map[i][j + 1];
          map[i][j + 1] = temp;

          temp = map[j][i];
          map[j][i] = map[j + 1][i];
          map[j + 1][i] = temp;

          result = Math.max(result, checkCandy());

          temp = map[j][i];
          map[j][i] = map[j + 1][i];
          map[j + 1][i] = temp;
      }
    }

    System.out.println(result);
    br.close();
    bw.close();
  }

  public static int checkCandy() {
    int result = 1;

    for(int i = 0; i < N; i++) {
      int cnt = 1;

      for(int j = 1; j < N; j++) {
        if(map[i][j-1].equals(map[i][j])) {
          cnt++;
        } else {
          result = Math.max(result, cnt);
          cnt = 1;
        }
      }
      result = Math.max(result, cnt);
    }

    for(int i = 0; i < N; i++) {
      int cnt = 1;

      for(int j = 0; j < N-1; j++) {
        if(map[j+1][i].equals(map[j][i])) {
          cnt++;
        } else {
          result = Math.max(result, cnt);
          cnt = 1;
        }
      }
      result = Math.max(result, cnt);
    }
    return result;
  }
}