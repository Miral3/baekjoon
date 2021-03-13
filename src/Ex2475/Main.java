package Ex2475;

/*
문제 이름 : 검증
알고리즘 : 수학
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
    int sum = 0;

    for(int i = 0; i < 5; i++) {
      int transformNum = Integer.parseInt(input[i]);
      int square = (int)Math.pow(transformNum, 2);
      sum += square;
    }

    System.out.println(sum % 10);
    br.close();
    bw.close();
  }
}
