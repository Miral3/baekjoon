package Ex5032;

/*
문제 이름 : 탄산 음료
알고리즘 : 구현
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

    String[] input = br.readLine().split(" ");
    int e = Integer.parseInt(input[0]);
    int f = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);

    int empty = e + f;
    int result = 0;
    while(true) {
      int div = empty / c;
      int remain = empty % c;

      result += div;
      empty = div + remain;

      if(div == 0) {
        break;
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }
}