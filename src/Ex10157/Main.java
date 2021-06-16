package Ex10157;

/*
문제 이름 : 자리배정
알고리즘 : 구현
자료구조 : 2차원 배열
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

    String[] input = br.readLine().split(" ");
    int R = Integer.parseInt(input[0]);
    int C = Integer.parseInt(input[1]);
    int K = Integer.parseInt(br.readLine());
    int hall[][] = new int[C][R];

    if(K > R * C) {
      System.out.println(0);
      return;
    }
    int rowMax = R;
    int colMax = C;
    int y = C;
    int x = 0;
    int d = -1;
    int cnt = 1;
    while(0 <= rowMax || 0 <= colMax) {
      for(int i = 0; i < colMax; i++) {
        y = y + d;
        hall[y][x] = cnt;
        if(cnt == K) {
          System.out.println((x + 1) + " " + (C - y));
          return;
        }
        cnt++;
      }
      rowMax--;
      d = d * -1;
      for(int i = 0; i < rowMax; i++) {
        x = x + d;
        hall[y][x] = cnt;
        if(cnt == K) {
          System.out.println((x + 1) + " " + (C - y));
          return;
        }
        cnt++;
      }
      colMax--;
    }

    br.close();
    bw.close();
  }
}