package Ex1357;

/*
문제 이름 : 뒤집힌 덧셈
알고리즘 : 구현, 문자열
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
    String x = input[0];
    String y = input[1];

    int reverseX = Integer.parseInt(stringReverse(x));
    int reverseY = Integer.parseInt(stringReverse(y));
    int result = reverseX + reverseY;

    System.out.println(Integer.parseInt(stringReverse(Integer.toString(result))));

    br.close();
    bw.close();
  }

  public static String stringReverse(String str) {
    StringBuffer sb = new StringBuffer(str);
    String reverseStr = sb.reverse().toString();

    return reverseStr;
  }
}