package Ex1018;

/*
문제 이름 : 체스판 다시 칠하기
알고리즘 : 브루트 포스
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

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    String[][] chase = new String[N][M];

    for(int i = 0; i < N; i++) {
      input = br.readLine().split("");
      for(int j = 0; j < M; j++) {
        chase[i][j] = input[j];
      }
    }

    int min = 80;
    for(int a = 0; a < N-7; a++) {
      for (int b = 0; b < M - 7; b++) {
        int cntB = 0;
        int cntW = 0;
        for (int i = a; i < a + 8; i++) {
          for (int j = b; j < b + 8; j++) {
            if ((i + j) % 2 == 0) {
              if (chase[i][j].equals("B")) {
                cntW++;
              } else {
                cntB++;
              }
            } else {
              if (chase[i][j].equals("B")) {
                cntB++;
              } else {
                cntW++;
              }
            }
          }
        }
        min = Math.min(min, cntB);
        min = Math.min(min, cntW);
      }
    }

    bw.write(min + "\n");
    br.close();
    bw.close();
  }
}
