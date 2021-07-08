package Ex1748;

/*
문제 이름 : 수 이어 쓰기1
알고리즘 : 구현
자료구조 : long
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

    long result = 0;
    if(N < 10) {
      System.out.println(N);
      return;
    }

    result = 9;
    for(int i = 1; i <= 8; i++) {
      if(N >= Math.pow(10, i) && N < Math.pow(10, i+1)) {
        result += ((N - (Math.pow(10, i) - 1)) * (i+1));
      } else if(N >= Math.pow(10, i + 1)) {
        result += (i + 1) * Math.pow(10, i) * 9;
      } else {
        break;
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }
}