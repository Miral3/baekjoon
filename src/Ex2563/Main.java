package Ex2563;

/*
문제 이름 : 색종이
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

    boolean[][] map = new boolean[101][101];

    int testCase = Integer.parseInt(br.readLine());
    int cnt = 0;
    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);

      for(int j = x ; j < x + 10; j++) {
        for (int k = y; k < y + 10; k++) {
          if (map[j][k]) {
            continue;
          } else {
            map[j][k] = true;
            cnt++;
          }
        }
      }
    }

    System.out.println(cnt);

    br.close();
    bw.close();
  }
}