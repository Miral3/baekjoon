package Ex1225;

/*
문제 이름 : 이상한 곱셈
알고리즘 : 문자열
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
    String A = input[0];
    String B = input[1];

    long sum = 0;
    for(int i = 0; i < A.length(); i++) {
      for(int j = 0; j < B.length(); j++) {
        sum += (A.charAt(i)-'0') * (B.charAt(j)-'0');
      }
    }
    System.out.println(sum);
    br.close();
    bw.close();
  }
}