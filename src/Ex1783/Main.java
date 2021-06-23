package Ex1783;

/*
문제 이름 : 병든 나이트
알고리즘 : 구현
자료구조 : 문자열
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

    if(N == 1) {
      System.out.println(1);
    } else if(N == 2) {
      System.out.println(Math.min(4, (M + 1) / 2));
    } else if(M < 7) {
      System.out.println(Math.min(4, M));
    } else {
      System.out.println(M - 7 + 5);
    }

    br.close();
    bw.close();
  }
}