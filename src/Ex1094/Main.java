package Ex1094;

/*
문제 이름 : 비슷한 단어
알고리즘 : 비트마스크
자료구조 : 
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

    int X = Integer.parseInt(br.readLine());

    int cnt = 1;
    while(X >= 2) {
      int remain = X % 2;
      if(remain == 1) {
        cnt++;
      }
      X = X / 2;
    }

    System.out.println(cnt);

    br.close();
    bw.close();
  }
}