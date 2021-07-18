package Ex1347;

/*
문제 이름 : 비슷한 단어
알고리즘 : 구현
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split("");
    String[][] map = new String[101][101];

    map[50][50] = ".";
    int angle = 180;
    int y = 50;
    int x = 50;
    int yMin = 50;
    int yMax = 50;
    int xMin = 50;
    int xMax = 50;
    for(int i = 0 ; i < N; i++) {
      if(input[i].equals("F")) {
        switch (angle) {
          case 0 :
            y -= 1;
            break;
          case 90 :
            x += 1;
            break;
          case 180 :
            y += 1;
            break;
          case 270 :
            x -= 1;
            break;
        }
        map[y][x] = ".";
        if(yMax < y) {
          yMax = y;
        }
        if(yMin > y) {
          yMin = y;
        }
        if(xMax < x) {
          xMax = x;
        }
        if(xMin > x) {
          xMin = x;
        }
      } else {
        if (input[i].equals("R")) {
          angle += 90;
        } else if (input[i].equals("L")) {
          angle -= 90;
        }
        if (angle < 0) {
          angle += 360;
        }
        if (angle == 360) {
          angle = 0;
        }
        angle %= 360;
      }
    }

    for(int i = yMin; i <= yMax; i++) {
      for(int j = xMin; j <= xMax; j++) {
        if(map[i][j] == null) {
          map[i][j] = "#";
        }
        bw.write(map[i][j] + "");
      }
      bw.write("\n");
    }

    br.close();
    bw.close();
  }
}
