package Ex1236;

/*
문제 이름 : 성 지키기
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

    String[] input1 = br.readLine().split(" ");
    int N = Integer.parseInt(input1[0]);
    int M = Integer.parseInt(input1[1]);
    String[][] map = new String[N][M];
    boolean[] row = new boolean[N];
    boolean[] column = new boolean[M];

    for(int i = 0; i < N; i++) {
      String[] input2 = br.readLine().split("");
      for(int j = 0; j < M; j++) {
        map[i][j] = input2[j];
        if(input2[j].equals("X")) {
          row[i] = true;
          column[j] = true;
        }
      }
    }

    int r = 0;
    for(int i = 0; i < N; i++) {
      if(!row[i]) {
        r++;
      }
    }

    int c = 0;
    for(int i = 0; i < M; i++) {
      if(!column[i]) {
        c++;
      }
    }

    int result = Math.max(r, c);

    System.out.println(result);

    br.close();
    bw.close();
  }
}