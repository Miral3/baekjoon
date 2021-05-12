package Ex1051;

/*
문제 이름 : 숫자 정사각형
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

    String[] input = br.readLine().split(" ");
    int x = Integer.parseInt(input[1]);
    int y = Integer.parseInt(input[0]);
    int[][] rectangle = new int[y][x];

    for(int i = 0; i < y; i++) {
      String[] num = br.readLine().split("");
      for(int j = 0; j < x; j++) {
        rectangle[i][j] = Integer.parseInt(num[j]);
      }
    }

    int min = x < y ? x : y;
    int max = 1;
    for(int i = 0; i < y; i++) {
      for(int j = 0; j < x; j++) {
        for(int k = 1; k < min; k++) {
          if(i+k < y && j+k < x) {
            if (rectangle[i][j] == rectangle[i][j + k] && rectangle[i][j + k] == rectangle[i + k][j]
                && rectangle[i + k][j] == rectangle[i + k][j + k]) {
              if(max < k+1) {
                max = k+1;
              }
            }
          }
        }
      }
    }

    bw.write((int)Math.pow(max, 2) + "\n");
    br.close();
    bw.close();
  }
}

