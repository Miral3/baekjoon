package Ex1356;

/*
문제 이름 : 유진수
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

    int N = Integer.parseInt(br.readLine());

    if(N < 10) {
      System.out.println("NO");
      return;
    } else {
      String str = Integer.toString(N);
      int size = str.length();
      for(int i = 1; i < size; i++) {
        String x = str.substring(0, i);
        String y = str.substring(i);
        int sumX = 1;
        int sumY = 1;

        for(int j = 0; j < x.length(); j++) {
          sumX *= x.charAt(j) - '0';
        }
        for(int j = 0 ; j < y.length(); j++) {
          sumY *= y.charAt(j) - '0';
        }

        if(sumX == sumY) {
          System.out.println("YES");
          return;
        }
      }
    }

    System.out.println("NO");

    br.close();
    bw.close();
  }
}