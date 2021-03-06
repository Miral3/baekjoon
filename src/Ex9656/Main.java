package Ex9656;

/*
문제 이름 : 돌 게임 2
알고리즘 : 다이나믹 프로그래밍
자료구조 : 정수
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

    if(N % 2 == 0) {
      System.out.println("SK");
    } else {
      System.out.println("CY");
    }

    br.close();
    bw.close();
  }
}